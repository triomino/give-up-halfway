# build
FROM adoptopenjdk/openjdk11 as builder
WORKDIR /workspace
COPY . .
RUN ./dependencies.sh && ./build.sh

# running
FROM tomcat:9.0.14-jre11-slim as runner
COPY --from=0 /workspace/build/libs/api.war ${CATALINA_HOME}/webapps/
ENTRYPOINT ${CATALINA_HOME}/bin/catalina.sh run