#!/bin/bash
#############################
# scss compile
#############################
currentDir=$(cd $(dirname $0); pwd)
srcDir=./assets/css
distDir=./public/assets/css

cd ${currentDir}
rbenv exec sass --watch "${srcDir}:${distDir}"