


Extracting data from dblp F.A.Q:
    How can I download the whole dblp dataset?
        https://dblp.org/faq/1474679.html
    What do I find in dblp.xml?
        https://dblp.org/faq/16154937.html
    How are data annotations used in dblp.xml?
        https://dblp.org/faq/17334559.html
    How to parse dblp.xml?
        https://dblp.org/faq/1474681.html
    
The dblp.xml is a simple, plain ASCII XML file, using the named entities as given in the accompanying dblp.dtd file.
A daily updated (but unversioned) XML dump can be found on the dblp web server: 
    https://dblp.org/xml/
	    dblp.xml.gz		                   compressed (gzip) version of an XML file which contains all bibliographic records
        dblp.dtd 		                   the Document Type Definition (DTD) required to validate the XML file

Furthermore, each month, a persistent snapshot release is archived:
    https://dblp.org/xml/release/

More information on the XML structure of the dblp records and several design decisions can be found in the following paper:
    https://dblp.uni-trier.de/xml/docu/dblpxml.pdf


hw2/src/main/resources/bin
    dtd2xsd.pl                              perl script to convert Document Type Definition (DTD) to XML Schema Definition (XSD)
    inspectdblp.sh                          bash script to extract count for each bibliographic record and other elements in the XML
hw2/src/main/java/com/ashessin/cs441/hw2/dblp/utils
    ExtractGzip.java                        extracts a gzip file
    PublicationsSequenceFileWriter.java     loads relavent XML elemnts from local file to HDFS using StAX API as a SequenceFile
    PublicationsSequenceFileReader.java     reads a SequenceFile from the HDFS
    PublicationWritable.java                to serialize and deserialize fields
hw2/src/main/java/com/ashessin/cs441/hw2/dblp/mr/
    SimpleCount.java                        counts the number of occurrences of a field
    CompositeCount.java                     counts the number of occurrences of a field set
    PrimaryCount.java                       counts the number of occurrences of the primary field
    SwapKeyVal.java                         swaps key value pairs and then sorts (descending) 