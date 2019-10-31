


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
	    dblp.xml.gz		is a compressed (gzip) version of an XML file which contains all bibliographic records
        dblp.dtd 		is	the document type definition you need to validate the XML file

Furthermore, each month, a persistent snapshot release is archived:
    http://dblp.org/xml/release/