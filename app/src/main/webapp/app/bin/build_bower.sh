#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
source ${execDir}/_common.sh

# copy bower_componets to outDir
rm -rf ${baseDir}/${outPrefix}/bower_components
cp -Rf ${baseDir}/${srcPrefix}/bower_components ${baseDir}/${outPrefix}