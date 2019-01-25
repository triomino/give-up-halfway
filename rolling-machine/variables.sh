#!/usr/bin/env bash
# dependencies
DEP_PATH=dep

# built libraries
LIB_PATH=build/libs

# package file
RELEASE=build/libs/api.war

###### dependencies below ######
# tomcat
TOMCAT_MAJOR_VERSION=9
TOMCAT_VERSION=9.0.14
CATALINA_HOME=${DEP_PATH}/apache-tomcat-${TOMCAT_VERSION}
CATALINA_BASE=${CATALINA_HOME}

# tomcat source link and archive file name
TOMCAT_LINK=http://mirrors.hust.edu.cn/apache/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz
TOMCAT_ARCHIVE=apache-tomcat-${TOMCAT_VERSION}.tar.gz

ORG_JSON_JAR=json-20180813.jar
ORG_JSON_LINK=https://search.maven.org/remotecontent?filepath=org/json/json/20180813/${ORG_JSON_JAR}

###### dependencies above ######

# built classes
BUILD_PATH=build/classes

# web path
WEB_PATH=src/main/web

# tmp path
TMP_PATH=build/tmp

# hand written java source
JAVA_SRC=src/main/java