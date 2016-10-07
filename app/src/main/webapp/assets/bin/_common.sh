#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/assets/bin
baseDir=$(dirname ${execDir})       # webapp/assets
parentDir=$(dirname ${baseDir})     # webapp

cssSrcDir=${baseDir}/css
cssOutDir=${parentDir}/resources/css
jsSrcDir=${baseDir}/js
jsOutDir=${parentDir}/resources/js
htmlSrcDir=${baseDir}/html
htmlOutDir=${parentDir}/resources/html