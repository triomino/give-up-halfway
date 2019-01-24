#!/usr/bin/env bash

source variables.sh

if [[ ! -f ${DEP_PATH} ]]; then
    mkdir -p ${DEP_PATH}
fi
if [[ ! -f ${DEP_PATH}/${TOMCAT_ARCHIVE} ]]; then
    curl ${TOMCAT_LINK} --output ${DEP_PATH}/${TOMCAT_ARCHIVE}
    tar -xzf ${DEP_PATH}/${TOMCAT_ARCHIVE} -C ${DEP_PATH}
fi

if [[ ! -f ${DEP_PATH}/${ORG_JSON_JAR} ]]; then
    curl ${ORG_JSON_LINK} --output ${DEP_PATH}/${ORG_JSON_JAR}
fi