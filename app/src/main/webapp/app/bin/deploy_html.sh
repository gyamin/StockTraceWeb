#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
source ${execDir}/_common.sh

# deploy html files
if [ "${1}" = "watch" ]; then
    ${baseDir}/node_modules/watch/cli.js "rsync -av --delete ${htmlSrcDir}/ ${htmlOutDir}/" ${htmlSrcDir}
else
    rsync -av --delete ${htmlSrcDir}/ ${htmlOutDir}/
fi