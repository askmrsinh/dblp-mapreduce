package com.ashessin.cs441.hw2.dblp;

import com.ashessin.cs441.hw2.dblp.mr.JoinedFieldsCount;
import com.ashessin.cs441.hw2.dblp.mr.SingleFieldCount;
import com.ashessin.cs441.hw2.dblp.mr.SwapSortKeyValuePairs;
import com.ashessin.cs441.hw2.dblp.utils.CopyHdfsFileToLocal;
import com.ashessin.cs441.hw2.dblp.utils.ExtractLocalGzipFile;
import com.ashessin.cs441.hw2.dblp.utils.PublicationsSequenceFileReader;
import com.ashessin.cs441.hw2.dblp.utils.PublicationsSequenceFileWriter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.log4j.PropertyConfigurator.configure;

public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);
    private Options options;
    private CommandLine cmd;


    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);

        PublicationsSequenceFileWriter.main(new String[]{
                args[0],
                "/cs441/hw2/input/publications.seqfile.deflate"
        });
        PublicationsSequenceFileReader.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate"});

        JoinedFieldsCount.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate",
                "/cs441/hw2/JoinedFieldsCount",
                "authors,authors"});
        SwapSortKeyValuePairs.main(new String[]{
                "/cs441/hw2/JoinedFieldsCount/part-r-00000",
                "/cs441/hw2/SwapSortKeyValuePairs1"});
        CopyHdfsFileToLocal.main(new String[]{
                "/cs441/hw2/SwapSortKeyValuePairs1/part-r-00000.gz",
                "SwapSortKeyValuePairs1/part-r-00000.gz"});
        ExtractLocalGzipFile.main(new String[]{
                "SwapSortKeyValuePairs1/part-r-00000.gz",
                args[1]});

        SingleFieldCount.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate",
                "/cs441/hw2/SingleFieldCount",
                "authors"});
        SwapSortKeyValuePairs.main(new String[]{
                "/cs441/hw2/SingleFieldCount/part-r-00000",
                "/cs441/hw2/SwapSortKeyValuePairs2"});
        CopyHdfsFileToLocal.main(new String[]{
                "/cs441/hw2/SwapSortKeyValuePairs2/part-r-00000.gz",
                "SwapSortKeyValuePairs2/part-r-00000.gz"});
        ExtractLocalGzipFile.main(new String[]{
                "SwapSortKeyValuePairs2/part-r-00000.gz",
                "SwapSortKeyValuePairs2/part-r-00000"});

    }
}