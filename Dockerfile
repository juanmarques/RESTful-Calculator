FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/calculator-api*.jar calculator-api.jar
CMD java ${JAVA_OPTS} -jar calculator-api.jar