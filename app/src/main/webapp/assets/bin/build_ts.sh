#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/assets/bin
source ${execDir}/_common.sh

# compile typescript files
if [ "${1}" = "watch" ]; then
    tsc -w --rootDir ${jsSrcDir} --outDir ${jsOutDir}
else
    tsc --rootDir ${jsSrcDir} --outDir ${jsOutDir}
fi