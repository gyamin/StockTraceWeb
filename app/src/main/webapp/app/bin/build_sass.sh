#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
source ${execDir}/_common.sh

# compile sass files
if [ "${1}" = "watch" ]; then
    ${baseDir}/node_modules/node-sass/bin/node-sass -w -r ${cssSrcDir} -o ${cssOutDir}
else
    ${baseDir}/node_modules/node-sass/bin/node-sass -r ${cssSrcDir}  -o ${cssOutDir}
fi