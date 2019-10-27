#!/bin/bash

dblp_xml_filepath=$1

grep -o '</article>\|</inproceedings>\|</proceedings>\|</book>\|</incollection>\|</phdthesis>\|</mastersthesis>\|</www>|</data>' "$dblp_xml_filepath" | wc -l


grep -o '</article>' "$dblp_xml_filepath" | wc -l
grep -o '</inproceedings>' "$dblp_xml_filepath" | wc -l
grep -o '</proceedings>' "$dblp_xml_filepath" | wc -l
grep -o '</book>' "$dblp_xml_filepath" | wc -l
grep -o '</incollection>' "$dblp_xml_filepath"| wc -l
grep -o '</phdthesis>' "$dblp_xml_filepath"| wc -l
grep -o '</mastersthesis>' "$dblp_xml_filepath"| wc -l
grep -o '</www>' "$dblp_xml_filepath"| wc -l
grep -o '</person>' "$dblp_xml_filepath"| wc -l
grep -o '</data>' "$dblp_xml_filepath"| wc -l


pcregrep -Mi "</author>([\s].*)?<author>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</editor>([\s].*)?<editor>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</title>([\s].*)?<title>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</booktitle>([\s].*)?<booktitle>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</pages>([\s].*)?<pages>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</year>([\s].*)?<year>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</address>([\s].*)?<address>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</journal>([\s].*)?<journal>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</volume>([\s].*)?<volume>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</number>([\s].*)?<number>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</month>([\s].*)?<month>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</url>([\s].*)?<url>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</ee>([\s].*)?<ee>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</cdrom>([\s].*)?<cdrom>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</cite>([\s].*)?<cite>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</publisher>([\s].*)?<publisher>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</crossref>([\s].*)?<crossref>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</isbn>([\s].*)?<isbn>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</series>([\s].*)?<series>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</school>([\s].*)?<school>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</chapter>([\s].*)?<chapter>" "$dblp_xml_filepath" | wc -l
pcregrep -Mi "</publnr>([\s].*)?<publnr>" "$dblp_xml_filepath" | wc -l
