#!/usr/bin/env bash

source variables.sh

rm -r ${CATALINA_BASE}/webapps/*
cp ${RELEASE} ${CATALINA_BASE}/webapps/
