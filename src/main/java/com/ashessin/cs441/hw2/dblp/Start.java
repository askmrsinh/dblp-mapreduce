package com.ashessin.cs441.hw2.dblp;

import com.ashessin.cs441.hw2.dblp.mr.JoinedFieldsCount;
import com.ashessin.cs441.hw2.dblp.mr.PrimaryFieldCount;
import com.ashessin.cs441.hw2.dblp.mr.SingleFieldCount;
import com.ashessin.cs441.hw2.dblp.mr.SwapSortKeyValuePairs;
import com.ashessin.cs441.hw2.dblp.utils.CopyHdfsFileToLocal;
import com.ashessin.cs441.hw2.dblp.utils.ExtractLocalGzipFile;
import com.ashessin.cs441.hw2.dblp.utils.PublicationsSequenceFileReader;
import com.ashessin.cs441.hw2.dblp.utils.PublicationsSequenceFileWriter;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * Projects main class.
 */
public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);

    /**
     * Default constructor that parses command line parameters
     * and actually execute the tool.
     *
     * @param args command line parameters
     */
    private Start(final String[] args) {
        try {

            if (!parseCommandLineOptions(args)) {
                System.exit(1);
            } else {
                System.exit(0);
            }
        } catch (ConfigException.Missing e) {
            logger.error("trying to load the input config file: ", e);
        } catch (ConfigException.Parse e) {
            logger.error("trying to parse the input config file: ", e);
        } catch (Exception e) {
            logger.error("An unexpected error happened: ", e);
        }

    }

    public static void main(String[] args) {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);

        new Start(args);
    }

    private boolean parseCommandLineOptions(String[] args) throws Exception {

        if (args.length < 1) {
            System.out.println(showHelp());
            return false;
        }

        if (args[0].trim().equalsIgnoreCase("--configFile")) {
            if (args.length == 2) {
                File configFile = new File(args[1]);
                logger.info("Trying to load config file {}", configFile.getAbsolutePath());
                executeConfig(configFile);
            } else {
                logger.info("Executing default config");
                File confgFile = new File(Objects.requireNonNull(
                        Thread.currentThread().getContextClassLoader().getResource("reference.conf")).toURI());
                executeConfig(confgFile);
            }
            return true;
        }

        String className = args[0].trim();
        String[] argsNew = Arrays.copyOfRange(args, 1, args.length);

        if (className.equalsIgnoreCase("-w") ||
                className.equals(PublicationsSequenceFileWriter.class.getName()) ||
                className.equals(PublicationsSequenceFileWriter.class.getSimpleName())) {
            PublicationsSequenceFileWriter.main(argsNew);
            return true;
        } else if (className.equalsIgnoreCase("-r") ||
                className.equals(PublicationsSequenceFileReader.class.getName()) ||
                className.equals(PublicationsSequenceFileReader.class.getSimpleName())) {
            PublicationsSequenceFileReader.main(argsNew);
            return true;
        } else if (className.equalsIgnoreCase("-c") ||
                className.equals(CopyHdfsFileToLocal.class.getName()) ||
                className.equals(CopyHdfsFileToLocal.class.getSimpleName())) {
            CopyHdfsFileToLocal.main(argsNew);
            return true;
        } else if (className.equalsIgnoreCase("-e") ||
                className.equals(ExtractLocalGzipFile.class.getName()) ||
                className.equals(ExtractLocalGzipFile.class.getSimpleName())) {
            ExtractLocalGzipFile.main(argsNew);
            return true;
        } else if (className.equals(SingleFieldCount.class.getName()) ||
                className.equals(SingleFieldCount.class.getSimpleName())) {
            SingleFieldCount.main(argsNew);
            return true;
        } else if (className.equals(JoinedFieldsCount.class.getName()) ||
                className.equals(JoinedFieldsCount.class.getSimpleName())) {
            JoinedFieldsCount.main(argsNew);
            return true;
        } else if (className.equals(PrimaryFieldCount.class.getName()) ||
                className.equals(PrimaryFieldCount.class.getSimpleName())) {
            PrimaryFieldCount.main(argsNew);
            return true;
        } else if (className.equals(SwapSortKeyValuePairs.class.getName()) ||
                className.equals(SwapSortKeyValuePairs.class.getSimpleName())) {
            SwapSortKeyValuePairs.main(argsNew);
            return true;
        } else {
            System.out.println(showHelp());
        }
        return false;

    }

    private void executeConfig(File configSource) throws Exception {
        if (configSource == null || "".equals(configSource.getAbsolutePath())) {
            throw new IllegalArgumentException("You must specify a file as command line parameter to --configFile.");
        }
        final Config config = ConfigFactory.load(configSource.getPath());
        List<? extends Config> jobs = config.getConfigList("jobs");
        for (Config job : jobs) {
            List<String> arguments = new ArrayList<>(3);
            arguments.add(job.getString("class"));
            arguments.addAll(job.getStringList("args"));
            parseCommandLineOptions(arguments.toArray(new String[0]));
        }
    }

    private String showHelp() throws IOException, URISyntaxException {
        return(new String(Files.readAllBytes(Paths.get(
                Thread.currentThread().getContextClassLoader().getResource("help.txt").toURI())))
                .replaceAll(Start.class.getName(), getApplicationStartCmd()));
    }

    /**
     * Gets the command used to launch the application.
     * <p>
     * If the application was launched from the jar file, returns a command like "java -jar name-of-the-jar-file".
     * If it was launched directly from the class file, returns a command like "java class-file".
     *
     * @return
     */
    private String getApplicationStartCmd() {
        final String fullClassFilePath = getFullClassFilePath();
        final String jarFile = regexMatch(fullClassFilePath);
        return (jarFile.isEmpty()) ? "java " + Start.class.getName() : "hadoop jar " + jarFile;
    }

    private String regexMatch(final String text) {
        final Matcher matcher = Pattern.compile(".*\\/(.*\\.jar).*\\/").matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return "";
    }

    /**
     * Gets the full file path of this class.
     * This may include the path of a jar if the class is being run from a jar package.
     *
     * @return
     */
    private String getFullClassFilePath() {
        final String classFileName = '/' + Start.class.getName().replace('.', '/') + ".class";
        return Start.class.getResource(classFileName).getFile();
    }
    // TODO: Improve config file parsing and cli options
}