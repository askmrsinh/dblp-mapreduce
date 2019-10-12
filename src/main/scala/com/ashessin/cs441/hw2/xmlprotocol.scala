package com.ashessin.cs441.hw2
    
/**
usage:
val obj = scalaxb.fromXML[com.ashessin.cs441.hw2.Foo](node)
val document = scalaxb.toXML[com.ashessin.cs441.hw2.Foo](obj, "foo", com.ashessin.cs441.hw2.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  val defaultScope = scalaxb.toScope(Some("t") -> "http://www.w3.org/namespace/",
    Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val Hw2DblpFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Dblp] = new DefaultHw2DblpFormat {}
  implicit lazy val Hw2ArticleFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Article] = new DefaultHw2ArticleFormat {}
  implicit lazy val Hw2InproceedingsFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Inproceedings] = new DefaultHw2InproceedingsFormat {}
  implicit lazy val Hw2ProceedingsFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Proceedings] = new DefaultHw2ProceedingsFormat {}
  implicit lazy val Hw2BookFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Book] = new DefaultHw2BookFormat {}
  implicit lazy val Hw2IncollectionFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Incollection] = new DefaultHw2IncollectionFormat {}
  implicit lazy val Hw2PhdthesisFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Phdthesis] = new DefaultHw2PhdthesisFormat {}
  implicit lazy val Hw2MastersthesisFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Mastersthesis] = new DefaultHw2MastersthesisFormat {}
  implicit lazy val Hw2WwwFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Www] = new DefaultHw2WwwFormat {}
  implicit lazy val Hw2DataFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Data] = new DefaultHw2DataFormat {}
  implicit lazy val Hw2PersonFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Person] = new DefaultHw2PersonFormat {}
  implicit lazy val Hw2PersonSequence1Format: scalaxb.XMLFormat[com.ashessin.cs441.hw2.PersonSequence1] = new DefaultHw2PersonSequence1Format {}
  implicit lazy val Hw2AuthorFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Author] = new DefaultHw2AuthorFormat {}
  implicit lazy val Hw2EditorFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Editor] = new DefaultHw2EditorFormat {}
  implicit lazy val Hw2AddressFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Address] = new DefaultHw2AddressFormat {}
  implicit lazy val Hw2TitleFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Title] = new DefaultHw2TitleFormat {}
  implicit lazy val Hw2BooktitleFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Booktitle] = new DefaultHw2BooktitleFormat {}
  implicit lazy val Hw2PagesFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Pages] = new DefaultHw2PagesFormat {}
  implicit lazy val Hw2YearFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Year] = new DefaultHw2YearFormat {}
  implicit lazy val Hw2JournalFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Journal] = new DefaultHw2JournalFormat {}
  implicit lazy val Hw2VolumeFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Volume] = new DefaultHw2VolumeFormat {}
  implicit lazy val Hw2NumberFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Number] = new DefaultHw2NumberFormat {}
  implicit lazy val Hw2MonthFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Month] = new DefaultHw2MonthFormat {}
  implicit lazy val Hw2UrlFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Url] = new DefaultHw2UrlFormat {}
  implicit lazy val Hw2EeFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Ee] = new DefaultHw2EeFormat {}
  implicit lazy val Hw2CiteFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Cite] = new DefaultHw2CiteFormat {}
  implicit lazy val Hw2SchoolFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.School] = new DefaultHw2SchoolFormat {}
  implicit lazy val Hw2PublisherFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Publisher] = new DefaultHw2PublisherFormat {}
  implicit lazy val Hw2NoteFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Note] = new DefaultHw2NoteFormat {}
  implicit lazy val Hw2CdromFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Cdrom] = new DefaultHw2CdromFormat {}
  implicit lazy val Hw2CrossrefFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Crossref] = new DefaultHw2CrossrefFormat {}
  implicit lazy val Hw2IsbnFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Isbn] = new DefaultHw2IsbnFormat {}
  implicit lazy val Hw2ChapterFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Chapter] = new DefaultHw2ChapterFormat {}
  implicit lazy val Hw2SeriesFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Series] = new DefaultHw2SeriesFormat {}
  implicit lazy val Hw2PublnrFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Publnr] = new DefaultHw2PublnrFormat {}
  implicit lazy val Hw2RefFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Ref] = new DefaultHw2RefFormat {}
  implicit lazy val Hw2SupFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Sup] = new DefaultHw2SupFormat {}
  implicit lazy val Hw2SubFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Sub] = new DefaultHw2SubFormat {}
  implicit lazy val Hw2IFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.I] = new DefaultHw2IFormat {}
  implicit lazy val Hw2TtFormat: scalaxb.XMLFormat[com.ashessin.cs441.hw2.Tt] = new DefaultHw2TtFormat {}

  trait DefaultHw2DblpFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Dblp] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Dblp] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "article")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Article](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "inproceedings")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Inproceedings](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "proceedings")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Proceedings](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "book")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Book](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "incollection")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Incollection](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "phdthesis")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Phdthesis](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "mastersthesis")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Mastersthesis](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "www")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Www](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "person")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Person](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "data")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Data](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Dblp(p1.toSeq,
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Dblp, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Dblp, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.dblpoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.DblpOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2ArticleFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Article] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Article] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Article(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@reviewid").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@rating").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Article, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.reviewid foreach { x => attr = scala.xml.Attribute(null, "reviewid", x.toString, attr) }
      __obj.rating foreach { x => attr = scala.xml.Attribute(null, "rating", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Article, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.articleoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.ArticleOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2InproceedingsFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Inproceedings] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Inproceedings] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Inproceedings(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Inproceedings, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Inproceedings, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.inproceedingsoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.InproceedingsOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2ProceedingsFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Proceedings] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Proceedings] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Proceedings(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Proceedings, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Proceedings, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.proceedingsoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.ProceedingsOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2BookFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Book] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Book] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Book(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Book, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Book, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.bookoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.BookOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2IncollectionFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Incollection] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Incollection] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Incollection(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Incollection, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Incollection, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.incollectionoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.IncollectionOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2PhdthesisFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Phdthesis] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Phdthesis] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Phdthesis(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Phdthesis, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Phdthesis, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.phdthesisoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.PhdthesisOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2MastersthesisFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Mastersthesis] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Mastersthesis] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Mastersthesis(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Mastersthesis, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Mastersthesis, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.mastersthesisoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.MastersthesisOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2WwwFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Www] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Www] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Www(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Www, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Www, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.wwwoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.WwwOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2DataFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Data] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Data] =
      phrase(rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Author](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "editor")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Editor](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "title")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Title](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "booktitle")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Booktitle](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "pages")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Pages](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "year")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Year](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "address")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Address](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "journal")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Journal](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "volume")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Volume](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "number")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Number](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "month")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Month](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ee")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ee](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cdrom")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cdrom](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publisher")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publisher](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "isbn")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Isbn](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "series")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Series](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "school")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.School](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "chapter")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Chapter](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "publnr")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Publnr](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Data(p1.toSeq,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@publtype").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Data, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.publtype foreach { x => attr = scala.xml.Attribute(null, "publtype", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Data, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.dataoption flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.DataOption]](x, x.namespace, x.key, __scope, false) })

  }

  trait DefaultHw2PersonFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Person] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Person] =
      phrase((((rep(scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "author")) ~ 
      rep(((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "note")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Note](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "url")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Url](x, scalaxb.ElemName(node) :: stack)))) | 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "cite")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Cite](x, scalaxb.ElemName(node) :: stack)))))) ^^ 
        { case p1 ~ p2 => scalaxb.DataRecord(com.ashessin.cs441.hw2.PersonSequence1(p1.toSeq map { scalaxb.fromXML[com.ashessin.cs441.hw2.Author](_, scalaxb.ElemName(node) :: stack) },
        p2.toSeq)) }) ||| 
      ((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "crossref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Crossref](x, scalaxb.ElemName(node) :: stack))))) ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Person(p1,
        scalaxb.fromXML[String]((node \ "@key"), scalaxb.ElemName(node) :: stack),
        (node \ "@mdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@cdate").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Person, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
      __obj.mdate foreach { x => attr = scala.xml.Attribute(null, "mdate", x.toString, attr) }
      __obj.cdate foreach { x => attr = scala.xml.Attribute(null, "cdate", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Person, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (Some(__obj.personoption) map {x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.PersonOption]](x, x.namespace, x.key, __scope, false)} get)

  }

  trait DefaultHw2PersonSequence1Format extends scalaxb.XMLFormat[com.ashessin.cs441.hw2.PersonSequence1] {
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, com.ashessin.cs441.hw2.PersonSequence1] = Left("don't call me.")
    
    def writes(__obj: com.ashessin.cs441.hw2.PersonSequence1, __namespace: Option[String], __elementLabel: Option[String], 
        __scope: scala.xml.NamespaceBinding, __typeAttribute: Boolean): scala.xml.NodeSeq =
      Seq.concat(__obj.author flatMap { scalaxb.toXML[com.ashessin.cs441.hw2.Author](_, Some("http://www.w3.org/namespace/"), Some("author"), __scope, false) },
        __obj.personoption2 flatMap { x => scalaxb.toXML[scalaxb.DataRecord[com.ashessin.cs441.hw2.PersonOption2]](x, x.namespace, x.key, __scope, false) })


  }

  trait DefaultHw2AuthorFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Author] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Author] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Author(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@bibtex").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@orcid").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Author, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.bibtex foreach { x => attr = scala.xml.Attribute(null, "bibtex", x.toString, attr) }
      __obj.orcid foreach { x => attr = scala.xml.Attribute(null, "orcid", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Author, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2EditorFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Editor] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Editor] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Editor(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@orcid").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Editor, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.orcid foreach { x => attr = scala.xml.Attribute(null, "orcid", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Editor, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2AddressFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Address] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Address] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Address(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Address, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Address, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2TitleFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Title] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Title] =
      phrase(optTextRecord ~ 
      rep(((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sub")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sub](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sup")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sup](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "i")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.I](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "tt")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Tt](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ref](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) })) ~ 
      optTextRecord ^^
      { case p1 ~ p2 ~ p3 =>
      com.ashessin.cs441.hw2.Title(Seq.concat(p1.toList,
        p2.flatten,
        p3.toList),
        (node \ "@bibtex").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Title, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.bibtex foreach { x => attr = scala.xml.Attribute(null, "bibtex", x.toString, attr) }
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Title, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2BooktitleFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Booktitle] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Booktitle] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Booktitle(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Booktitle, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Booktitle, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2PagesFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Pages] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Pages] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Pages(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Pages, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Pages, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2YearFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Year] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Year] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Year(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Year, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Year, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2JournalFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Journal] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Journal] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Journal(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Journal, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Journal, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2VolumeFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Volume] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Volume] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Volume(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Volume, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Volume, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2NumberFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Number] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Number] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Number(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Number, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Number, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2MonthFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Month] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Month] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Month(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Month, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Month, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2UrlFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Url] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Url] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Url(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Url, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Url, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2EeFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Ee] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Ee] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Ee(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Ee, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Ee, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2CiteFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Cite] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Cite] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Cite(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@ref").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Cite, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      __obj.ref foreach { x => attr = scala.xml.Attribute(null, "ref", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Cite, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2SchoolFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.School] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.School] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.School(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.School, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.School, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2PublisherFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Publisher] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Publisher] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Publisher(Seq.concat(p1.toList),
        (node \ "@href").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Publisher, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.href foreach { x => attr = scala.xml.Attribute(null, "href", x.toString, attr) }
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Publisher, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2NoteFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Note] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Note] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Note(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Note, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Note, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2CdromFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Cdrom] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Cdrom] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Cdrom(Seq.concat(p1.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Cdrom, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2CrossrefFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Crossref] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Crossref] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Crossref(Seq.concat(p1.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Crossref, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2IsbnFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Isbn] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Isbn] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Isbn(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Isbn, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Isbn, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2ChapterFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Chapter] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Chapter] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Chapter(Seq.concat(p1.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Chapter, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2SeriesFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Series] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Series] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Series(Seq.concat(p1.toList),
        (node \ "@href").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Series, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.href foreach { x => attr = scala.xml.Attribute(null, "href", x.toString, attr) }
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Series, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2PublnrFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Publnr] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Publnr] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Publnr(Seq.concat(p1.toList),
        (node \ "@aux").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@label").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) },
        (node \ "@type").headOption map { scalaxb.fromXML[String](_, scalaxb.ElemName(node) :: stack) }) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Publnr, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.aux foreach { x => attr = scala.xml.Attribute(null, "aux", x.toString, attr) }
      __obj.label foreach { x => attr = scala.xml.Attribute(null, "label", x.toString, attr) }
      __obj.typeValue foreach { x => attr = scala.xml.Attribute(null, "type", x.toString, attr) }
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Publnr, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2RefFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Ref] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Ref] =
      phrase(optTextRecord ^^
      { case p1 =>
      com.ashessin.cs441.hw2.Ref(Seq.concat(p1.toList),
        scalaxb.fromXML[String]((node \ "@href"), scalaxb.ElemName(node) :: stack)) })
    
    override def writesAttribute(__obj: com.ashessin.cs441.hw2.Ref, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      attr = scala.xml.Attribute(null, "href", __obj.href.toString, attr)
      attr
    }

    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Ref, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2SupFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Sup] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Sup] =
      phrase(optTextRecord ~ 
      rep(((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sub")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sub](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sup")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sup](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "i")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.I](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "tt")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Tt](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ref](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) })) ~ 
      optTextRecord ^^
      { case p1 ~ p2 ~ p3 =>
      com.ashessin.cs441.hw2.Sup(Seq.concat(p1.toList,
        p2.flatten,
        p3.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Sup, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2SubFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Sub] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Sub] =
      phrase(optTextRecord ~ 
      rep(((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sub")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sub](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sup")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sup](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "i")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.I](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "tt")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Tt](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ref](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) })) ~ 
      optTextRecord ^^
      { case p1 ~ p2 ~ p3 =>
      com.ashessin.cs441.hw2.Sub(Seq.concat(p1.toList,
        p2.flatten,
        p3.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Sub, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2IFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.I] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.I] =
      phrase(optTextRecord ~ 
      rep(((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sub")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sub](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sup")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sup](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "i")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.I](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "tt")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Tt](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ref](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) })) ~ 
      optTextRecord ^^
      { case p1 ~ p2 ~ p3 =>
      com.ashessin.cs441.hw2.I(Seq.concat(p1.toList,
        p2.flatten,
        p3.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.I, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }

  trait DefaultHw2TtFormat extends scalaxb.ElemNameParser[com.ashessin.cs441.hw2.Tt] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/namespace/")
    
    override def isMixed: Boolean = true

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[com.ashessin.cs441.hw2.Tt] =
      phrase(optTextRecord ~ 
      rep(((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sub")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sub](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "sup")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Sup](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "i")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.I](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "tt")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Tt](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) }) ||| 
      ((((scalaxb.ElemName(Some("http://www.w3.org/namespace/"), "ref")) ^^ 
      (x => scalaxb.DataRecord(x.namespace, Some(x.name), scalaxb.fromXML[com.ashessin.cs441.hw2.Ref](x, scalaxb.ElemName(node) :: stack)))) ~ 
      optTextRecord) ^^ 
        { case p1 ~ p2 => Seq.concat(Seq(p1),
        p2.toList) })) ~ 
      optTextRecord ^^
      { case p1 ~ p2 ~ p3 =>
      com.ashessin.cs441.hw2.Tt(Seq.concat(p1.toList,
        p2.flatten,
        p3.toList)) })
    
    def writesChildNodes(__obj: com.ashessin.cs441.hw2.Tt, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      __obj.mixed.toSeq flatMap { x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, false) }

  }


}

