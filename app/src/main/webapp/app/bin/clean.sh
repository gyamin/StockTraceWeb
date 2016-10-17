#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
source ${execDir}/_common.sh

# remove all builds files
rm -rf ${cssOutDir}/*
rm -rf ${jsOutDir}/*
rm -rf ${htmlOutDir}/*