#!/usr/bin/env bash

source variables.sh
export CLASSPATH=${CATALINA_HOME}/lib/servlet-api.jar:${CLASSPATH}

# compile
echo Compiling

if [[ ! -d ${BUILD_PATH} ]]; then
    mkdir -p ${BUILD_PATH}
fi
javac src/main/java/indi/zya/api/servlets/*.java -d ${BUILD_PATH}

echo Compile Finished

# collecting
echo Collecting

# create and clean tmp folder
if [[ ! -d ${TMP_PATH} ]]; then
    mkdir -p ${TMP_PATH}
fi
rm -r ${TMP_PATH}/*
cp -r ${WEB_PATH}/* ${TMP_PATH}

echo Collect Finished

# package
echo Packaging

if [[ ! -d "${TMP_PATH}/WEB-INF/classes" ]]; then
    mkdir -p ${TMP_PATH}/WEB-INF/classes
fi
if [[ ! -d "${LIB_PATH}" ]]; then
    mkdir -p ${LIB_PATH}
fi
cp -r ${BUILD_PATH}/* ${TMP_PATH}/WEB-INF/classes
jar cvf ${RELEASE} -C ${TMP_PATH} .

echo Package Finished
