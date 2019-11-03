package com.ashessin.cs441.hw2.dblp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Extracts a Gzip file on local filesystem.
 */
public final class ExtractLocalGzipFile {
    private static final Logger logger = LoggerFactory.getLogger(ExtractLocalGzipFile.class);

    private InputStream in;

    private ExtractLocalGzipFile(File f) throws IOException {
        this.in = new FileInputStream(f);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        final String CWD = System.getProperty("user.dir") + File.separator;
        String gzipFilePath = args[0];

        if (!gzipFilePath.endsWith(".gz")) throw new AssertionError();
        File gzipFile = new File(gzipFilePath);

        String outputFilePath;
        if (args.length < 2) {
            outputFilePath = CWD + gzipFile.getName().substring(0, gzipFile.getName().length() - 3);
        } else {
            outputFilePath = args[1];
        }

        File outputFile = new File(outputFilePath);

        ExtractLocalGzipFile extractLocalGzipFile = new ExtractLocalGzipFile(gzipFile);
        extractLocalGzipFile.unzip(outputFile);
        int res = extractLocalGzipFile.close();

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        logger.info("ExtractLocalGzipFile, Memory used (bytes): {}", memend - memstart);
        logger.info("ExtractLocalGzipFile, Time taken (ms): {}", end - start);

        // System.exit(res);
    }

    private void unzip(File fileTo) throws IOException {
        final long MEGABYTE = 1024L * 1024L;
        long fileSize = in.available();
        logger.info("Extracting {} MiB compressed file as {}", fileSize / MEGABYTE, fileTo.getAbsolutePath());
        try (OutputStream out = new FileOutputStream(fileTo)) {
            // http://java-performance.info/java-io-bufferedinputstream-and-java-util-zip-gzipinputstream/
            in = new GZIPInputStream(in, 8192);
            byte[] buffer = new byte[65536];
            long extractedSize = 0L;
            int noRead;
            while ((noRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, noRead);
                extractedSize += noRead;
                logger.debug("Processed {} MiB ...\r", extractedSize / MEGABYTE);
            }
            out.flush();
            logger.info("Wrote {} MiB to {}", extractedSize / MEGABYTE, fileTo.getAbsolutePath());
        }
    }

    private int close() {
        try {
            in.close();
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    // TODO: Use better alternatives for handeling gzip file
}
