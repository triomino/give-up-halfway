#!/usr/bin/env bash

export CLASSPATH=/usr/share/tomcat8/lib/servlet-api.jar:${CLASSPATH}
source path.sh
BUILD_PATH=build/classes
WEB_PATH=src/main/web

# compile
echo Compiling

javac src/main/java/indi/zya/rollingmachine/servlets/HelloWorld.java -d ${BUILD_PATH}

echo Compile Finished

# package

echo Packaging

TMP_PATH=build/tmp
rm -r ${TMP_PATH}
cp -r ${WEB_PATH} ${TMP_PATH}
if [[ ! -d "${TMP_PATH}/WEB-INF/classes" ]]; then
    mkdir -p ${TMP_PATH}/WEB-INF/classes
fi
cp -r ${BUILD_PATH}/* ${TMP_PATH}/WEB-INF/classes
jar cvf ${RELEASE} -C ${TMP_PATH} .

echo Package Finished
