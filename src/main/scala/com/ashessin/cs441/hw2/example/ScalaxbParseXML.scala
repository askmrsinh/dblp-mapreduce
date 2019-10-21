package com.ashessin.cs441.hw2.example

import com.ashessin.cs441.hw2.{Article, Book, Dblp}

object ScalaxbParseXML {
  def main(args: Array[String]): Unit = {
    val test = <dblp xmlns="http://www.w3.org/namespace/">
      <article mdate="2018-01-07" key="tr/meltdown/s18" publtype="informal">
        <author>Paul Kocher</author>
        <author>Daniel Genkin</author>
        <author>Daniel Gruss</author>
        <author>Werner Haas</author>
        <author>Mike Hamburg</author>
        <author>Moritz Lipp</author>
        <author>Stefan Mangard</author>
        <author>Thomas Prescher 0002</author>
        <author>Michael Schwarz 0001</author>
        <author>Yuval Yarom</author>
        <title>Spectre Attacks: Exploiting Speculative Execution.</title>
        <journal>meltdownattack.com</journal>
        <year>2018</year>
        <ee>https://spectreattack.com/spectre.pdf</ee>
      </article>
      <article mdate="2018-01-07" key="tr/meltdown/m18" publtype="informal">
        <author>Moritz Lipp</author>
        <author>Michael Schwarz 0001</author>
        <author>Daniel Gruss</author>
        <author>Thomas Prescher 0002</author>
        <author>Werner Haas</author>
        <author>Stefan Mangard</author>
        <author>Paul Kocher</author>
        <author>Daniel Genkin</author>
        <author>Yuval Yarom</author>
        <author>Mike Hamburg</author>
        <title>Meltdown</title>
        <journal>meltdownattack.com</journal>
        <ee>https://meltdownattack.com/meltdown.pdf</ee>
        <year>2018</year>
      </article>
      <book mdate="2019-05-27" key="tr/acm/CS2013">
        <title>Computer Science Curricula 2013</title>
        <publisher>ACM Press and IEEE Computer Society Press</publisher>
        <year>2013</year>
        <ee>https://doi.org/10.1145/2534860</ee>
        <isbn>978-1-4503-2309-3</isbn>
      </book>
    </dblp>
    val obj = scalaxb.fromXML[Dblp](test)
    for (dblpoption <- obj.dblpoption) {
      println(dblpoption.key)
      println(dblpoption.namespace)
      println(dblpoption.value)

      if (dblpoption.value.isInstanceOf[Article])
        for (articleoption <- dblpoption.as[Article].articleoption)
          println(articleoption)
      if (dblpoption.value.isInstanceOf[Book])
        for (bookoption <- dblpoption.as[Book].bookoption)
          println(bookoption)

      println()
    }
  }
}
