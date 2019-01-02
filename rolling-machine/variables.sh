#!/usr/bin/env bash
# dependencies
DEP_PATH=dep

# built libraries
LIB_PATH=build/libs

# package file
RELEASE=build/libs/api.war

# tomcat
TOMCAT_MAJOR_VERSION=9
TOMCAT_VERSION=9.0.14
CATALINA_HOME=${DEP_PATH}/apache-tomcat-${TOMCAT_VERSION}
CATALINA_BASE=${CATALINA_HOME}

# tomcat source link and archive file name
TOMCAT_LINK=https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz
TOMCAT_ARCHIVE=apache-tomcat-${TOMCAT_VERSION}.tar.gz

# built classes
BUILD_PATH=build/classes

# web path
WEB_PATH=src/main/web

# tmp path
TMP_PATH=build/tmp