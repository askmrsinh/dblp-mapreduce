#!/bin/bash

# What do I find in dblp.xml?
# https://dblp.uni-trier.de/faq/16154937.html

# https://www.openoffice.org/bibliographic/bibtex-defs.html
# https://www.andy-roberts.net/res/writing/latex/bibentries.pdf

dblp_xml_filepath=$1

echo -e "\e[34mInspecting $dblp_xml_filepath for tags.\e[0m"

dblp_count=$(grep -o '</article>\|</inproceedings>\|</proceedings>\|</book>\|</incollection>\|</phdthesis>\|</mastersthesis>\|</www>\|</person>\|</data>' "$dblp_xml_filepath" | wc -l)
echo -e "\e[34mFound $dblp_count publication elements."
echo ""

echo -e "\e[34mCounting each child of the 'dblp' root element...\e[0m"
dblp_elements=(article inproceedings proceedings book incollection phdthesis mastersthesis www person data)
for i in "${dblp_elements[@]}"; do
  count=$(grep -o "</$i>" "$dblp_xml_filepath" | wc -l)
  echo "'$i': $count"
done
echo ""

echo -e "\e[34mCounting each grandchild of the 'dblp' root element...\e[0m"
other_elements=(author editor title booktitle pages year address journal volume number month url ee cdrom cite publisher crossref isbn series school chapter publnr)
for i in "${other_elements[@]}"; do
  count=$(grep -o "</$i>" "$dblp_xml_filepath" | wc -l)
  echo "'$i': $count"
done

command -v pcregrep >/dev/null 2>&1 || {
  echo >&2 'Require `pcregrep` but it is not installed. Aborting.'
  exit 1
}
echo ""

echo -e "\e[34mCounting identical sibling(s) that are grandchildren of the 'dblp' root element...\e[0m"
for i in "${other_elements[@]}"; do
  count=$(pcregrep -Mi "</$i>([\s].*)?<$i>" "$dblp_xml_filepath" | wc -l)
  echo "'</$i>...<$i>': $count"
done
