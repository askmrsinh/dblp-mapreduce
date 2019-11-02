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

public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);
    private Options options;
    private CommandLine cmd;


    public static void main(String[] args) throws Exception {

        PublicationsSequenceFileWriter.main(new String[]{
                "dblp-tiny.xml",
                "/cs441/hw2/input/publications.seqfile.deflate"
        });

        System.out.println("\n\n");

        PublicationsSequenceFileReader.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate"
        });

        System.out.println("\n\n");

        JoinedFieldsCount.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate",
                "/cs441/hw2/JoinedFieldsCount",
                "authors,authors"
        });

        System.out.println("\n\n");

        SwapSortKeyValuePairs.main(new String[]{
                "/cs441/hw2/JoinedFieldsCount/part-r-00000",
                "/cs441/hw2/SwapSortKeyValuePairs1"
        });
        CopyHdfsFileToLocal.main(new String[]{
                "/cs441/hw2/SwapSortKeyValuePairs1/part-r-00000.gz"
        });

        System.out.println("\n\n");

        SingleFieldCount.main(new String[]{
                "/cs441/hw2/input/publications.seqfile.deflate",
                "/cs441/hw2/SingleFieldCount",
                "authors"
        });

        System.out.println("\n\n");

        SwapSortKeyValuePairs.main(new String[]{
                "/cs441/hw2/SingleFieldCount/part-r-00000",
                "/cs441/hw2/SwapSortKeyValuePairs2"
        });
        CopyHdfsFileToLocal.main(new String[]{
                "/cs441/hw2/SwapSortKeyValuePairs2/part-r-00000.gz"
        });

        System.out.println("\n\n");
        ExtractLocalGzipFile.main(new String[]{"part-r-00000.gz"});

    }
}