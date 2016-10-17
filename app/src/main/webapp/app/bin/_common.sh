#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
baseDir=$(dirname ${execDir})       # webapp
#parentDir=$(dirname ${baseDir})     #

srcPrefix="src"
outPrefix="dist"

# set source dir and distribute dir
cssSrcDir=${baseDir}/${srcPrefix}/css
cssOutDir=${baseDir}/${outPrefix}/css
jsSrcDir=${baseDir}/${srcPrefix}/js
jsOutDir=${baseDir}/${outPrefix}/js
htmlSrcDir=${baseDir}/${srcPrefix}/html
htmlOutDir=${baseDir}/${outPrefix}/html