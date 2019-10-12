package com.ashessin.cs441.hw2


case class Dblp(dblpoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.DblpOption]] = Nil,
  mdate: Option[String] = None)

trait DblpOption

case class Article(articleoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.ArticleOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  reviewid: Option[String] = None,
  rating: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait ArticleOption

case class Inproceedings(inproceedingsoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.InproceedingsOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait InproceedingsOption

case class Proceedings(proceedingsoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.ProceedingsOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait ProceedingsOption

case class Book(bookoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.BookOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait BookOption

case class Incollection(incollectionoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.IncollectionOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait IncollectionOption

case class Phdthesis(phdthesisoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.PhdthesisOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait PhdthesisOption

case class Mastersthesis(mastersthesisoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.MastersthesisOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait MastersthesisOption

case class Www(wwwoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.WwwOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait WwwOption

case class Data(dataoption: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.DataOption]] = Nil,
  key: String,
  mdate: Option[String] = None,
  publtype: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait DataOption

case class Person(personoption: scalaxb.DataRecord[com.ashessin.cs441.hw2.PersonOption],
  key: String,
  mdate: Option[String] = None,
  cdate: Option[String] = None) extends DblpOption

trait PersonOption
case class PersonSequence1(author: Seq[com.ashessin.cs441.hw2.Author] = Nil,
  personoption2: Seq[scalaxb.DataRecord[com.ashessin.cs441.hw2.PersonOption2]] = Nil) extends PersonOption

trait PersonOption2

case class Author(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  bibtex: Option[String] = None,
  orcid: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Editor(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  orcid: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Address(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Title(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  bibtex: Option[String] = None,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption

trait TitleOption

case class Booktitle(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Pages(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Year(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Journal(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Volume(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Number(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Month(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Url(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption with PersonOption2


case class Ee(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Cite(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None,
  ref: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption with PersonOption2


case class School(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Publisher(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  href: Option[String] = None,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Note(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption with PersonOption2


case class Cdrom(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Crossref(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption with PersonOption


case class Isbn(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Chapter(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Series(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  href: Option[String] = None,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Publnr(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  aux: Option[String] = None,
  label: Option[String] = None,
  typeValue: Option[String] = None) extends ArticleOption with InproceedingsOption with ProceedingsOption with BookOption with IncollectionOption with PhdthesisOption with MastersthesisOption with WwwOption with DataOption


case class Ref(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  href: String) extends TitleOption with SupOption with SubOption with IOption with TtOption


case class Sup(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends TitleOption with SupOption with SubOption with IOption with TtOption

trait SupOption

case class Sub(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends TitleOption with SupOption with SubOption with IOption with TtOption

trait SubOption

case class I(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends TitleOption with SupOption with SubOption with IOption with TtOption

trait IOption

case class Tt(mixed: Seq[scalaxb.DataRecord[Any]] = Nil) extends TitleOption with SupOption with SubOption with IOption with TtOption

trait TtOption
