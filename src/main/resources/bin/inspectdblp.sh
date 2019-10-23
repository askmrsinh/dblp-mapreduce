#!/bin/bash

grep -o '</article>\|</inproceedings>\|</proceedings>\|</book>\|</incollection>\|</phdthesis>\|</mastersthesis>\|</www>' ../dblp.xml | wc -l


grep -o '</author>' dblp.xml | wc -l # use multi
grep -o '</journal>' dblp.xml | wc -l
grep -o '</school>' dblp.xml | wc -l # use multi
grep -o '</year>' dblp.xml | wc -l
grep -o '</crossref>' dblp.xml| wc -l
grep -o '</ee>' dblp.xml| wc -l #use multi