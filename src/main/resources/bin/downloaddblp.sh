#!/bin/bash

RESOURCE_DIR=$(dirname $(dirname $(readlink -fm $0)))
DBLP_NAME="dblp.xml"

# Downloading the dblp dataset, dtd, and checksum:
wget https://dblp.org/xml/$DBLP_NAME.gz -P $RESOURCE_DIR
wget https://dblp.org/xml/$DBLP_NAME.dtd -P $RESOURCE_DIR
wget https://dblp.org/xml/$DBLP_NAME.gz.md5 -P $RESOURCE_DIR


# Verifying the checksum:
md5sum -c $RESOURCE_DIR/$DBLP_NAME.gz.md5
