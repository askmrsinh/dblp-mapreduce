name := "hw2"

version := "0.1"

scalaVersion := "2.12.10"

mainClass in(Compile, run) := Some("com.ashessin.cs441.hw2.dblp.Start")
mainClass in(Compile, packageBin) := Some("com.ashessin.cs441.hw2.dblp.Start")

assemblyMergeStrategy in assembly := {
  case "dblp.xml" => MergeStrategy.discard
  case "main.log" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
assemblyOption in assembly := (assemblyOption in assembly).value.copy(cacheOutput = false)

libraryDependencies ++= Seq(
  "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
  "com.google.code.findbugs" % "jsr305" % "3.0.2",

  // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-client
  "org.apache.hadoop" % "hadoop-client" % "3.2.1",
  // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-hdfs
  "org.apache.hadoop" % "hadoop-hdfs" % "3.2.1",
  // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common
  "org.apache.hadoop" % "hadoop-common" % "3.2.1",

  // https://mvnrepository.com/artifact/com.typesafe/config
  "com.typesafe" % "config" % "1.4.0",
)