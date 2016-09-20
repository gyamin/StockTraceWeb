#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/assets/bin
baseDir=$(dirname ${execDir})       # webapp/assets
parentDir=$(dirname ${baseDir})     # webapp

cssSrcDir=${baseDir}/sass
cssOutDir=${parentDir}/resources/css
jsSrcDir=${baseDir}/ts
jsOutDir=${parentDir}/resources/js
htmlSrcDir=${baseDir}/html
htmlOutDir=${parentDir}/resources/html