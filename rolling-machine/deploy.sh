#!/usr/bin/env bash

source path.sh

CATALINA_BASE=~/software/apache-tomcat

rm -r ${CATALINA_BASE}/webapps/*
cp ${RELEASE} ${CATALINA_BASE}/webapps/
