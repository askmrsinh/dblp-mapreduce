#!/bin/bash

grep -o '</article>\|</inproceedings>\|</proceedings>\|</book>\|</incollection>\|</phdthesis>\|</mastersthesis>\|</www>' ../dblp.xml | wc -l
