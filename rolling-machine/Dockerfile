# build
FROM adoptopenjdk/openjdk11 as builder
WORKDIR /workspace
COPY . .
RUN ./dependencies.sh && ./build.sh

# running
FROM tomcat:9.0.14-jre11-slim as runner
COPY --from=builder /workspace/build/libs/api.war ${CATALINA_HOME}/webapps/
COPY --from=builder /workspace/dep/*.jar ${CATALINA_HOME}/lib/
ENTRYPOINT ${CATALINA_HOME}/bin/catalina.sh run
