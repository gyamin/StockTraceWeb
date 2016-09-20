#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/assets/bin
source ${execDir}/_common.sh

# deploy html files
if [ "${1}" = "watch" ]; then
    ${baseDir}/node_modules/watch/cli.js "cp -Rf ${htmlSrcDir} ${htmlOutDir}" ${htmlSrcDir}
else
    cp -Rf ${htmlSrcDir} ${htmlOutDir}
fi