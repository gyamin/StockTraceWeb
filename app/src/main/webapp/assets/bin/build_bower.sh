#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/assets/bin
source ${execDir}/_common.sh

# copy bower_componets to outDir
outDir=${parentDir}/resources
rm -rf ${outDir}/bower_components
cp -Rf ${baseDir}/bower_components ${outDir}