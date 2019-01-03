# Only running environments.
# Used to deploy and run. Building is not included. Build on host first.
FROM tomcat:9.0.14-jre11-slim
COPY build/libs/api.war ${CATALINA_HOME}/webapps/
ENTRYPOINT ${CATALINA_HOME}/bin/catalina.sh run