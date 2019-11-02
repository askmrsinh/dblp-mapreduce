package com.ashessin.cs441.hw2.dblp.utils;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Extracts a Gzip file on local filesystem.
 */
public final class ExtractLocalGzipFile {
    private InputStream in;

    public ExtractLocalGzipFile(File f) throws IOException {
        this.in = new FileInputStream(f);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        final String CWD = System.getProperty("user.dir") + File.pathSeparator;
        String gzipFilePath = args[0];

        if (!gzipFilePath.endsWith(".gz")) throw new AssertionError();
        File gzipFile = new File(gzipFilePath);

        String outputFilePath;
        if (args.length < 2) {
            outputFilePath = CWD + gzipFile.getName();
        } else {
            outputFilePath = args[1];
        }

        File outputFile = new File(outputFilePath);

        ExtractLocalGzipFile extractLocalGzipFile = new ExtractLocalGzipFile(gzipFile);
        extractLocalGzipFile.unzip(outputFile);
        int res = extractLocalGzipFile.close();

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("Extract Gzip file, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("Extract Gzip file, Time taken (ms): "
                + (end - start));

        // System.exit(res);
    }

    public void unzip(File fileTo) throws IOException {
        final long MEGABYTE = 1024L * 1024L;
        long fileSize = in.available();
        System.out.println("Extracting " + fileSize / MEGABYTE + " MiB compressed file as " + fileTo.getAbsolutePath());
        try (OutputStream out = new FileOutputStream(fileTo)) {
            // http://java-performance.info/java-io-bufferedinputstream-and-java-util-zip-gzipinputstream/
            in = new GZIPInputStream(in, 8192);
            byte[] buffer = new byte[65536];
            long extractedSize = 0L;
            int noRead;
            while ((noRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, noRead);
                extractedSize += noRead;
                System.out.print("Processed " + (extractedSize / MEGABYTE) + " MiB ...\r");
            }
            out.flush();
            System.out.println("Wrote " + (extractedSize / MEGABYTE) + " MiB to " + fileTo.getAbsolutePath());
        }
    }

    public int close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    // TODO: Use better alternatives for handeling gzip file
}
