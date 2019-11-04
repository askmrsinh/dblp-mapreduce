package com.ashessin.cs441.hw2.dblp

import java.io.File

import com.ashessin.cs441.hw2.dblp.mr.SingleFieldCount
import com.ashessin.cs441.hw2.dblp.utils.{PublicationsSequenceFileReader, PublicationsSequenceFileWriter}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.util.ToolRunner
import org.scalatest.FunSuite

class BasicTests extends FunSuite {
  val DBLP_TINY: Path = new Path(Thread.currentThread.getContextClassLoader.getResource("dblp-tiny.xml").getFile)
  val DBLP_DTD: Path = new Path(Thread.currentThread.getContextClassLoader.getResource("dblp.dtd").getFile)

  test("DBLP XML file must be present and readable") {
    val fileSystem = DBLP_TINY.getFileSystem(new Configuration)
    assert(fileSystem.exists(DBLP_TINY))
  }

  test("DBLP DTD file must be present and readable") {
    val fileSystem = DBLP_DTD.getFileSystem(new Configuration)
    assert(fileSystem.exists(DBLP_DTD))
  }

  // must match the number of records (ie. 13) in the dblp-tiny.xml file
  test("Publications Sequnce File Writer Test") {
    val args = new Array[String](2)
    args(0) = DBLP_TINY.toString
    args(1) = DBLP_TINY.getParent + File.separator + "_test/publications.sequnce.deflate"

    val i = ToolRunner.run(new Configuration, new PublicationsSequenceFileWriter, args)
    assert(i === 13)
  }

  test("Publications Sequnce File Reader Test") {
    val args = new Array[String](1)
    args(0) = DBLP_TINY.getParent + File.separator + "_test/publications.sequnce.deflate"

    val i = ToolRunner.run(new Configuration, new PublicationsSequenceFileReader, args)
    assert(i === 0)
  }

  test("Single Field Count MR Job Test") {
    val args = new Array[String](3)
    args(0) = DBLP_TINY.getParent + File.separator + "_test/publications.sequnce.deflate"
    args(1) = DBLP_TINY.getParent + "/_test/mr/"
    args(2) = "authors"

    val i = ToolRunner.run(new Configuration, new SingleFieldCount, args)
    assert(i === 0)
  }
}
