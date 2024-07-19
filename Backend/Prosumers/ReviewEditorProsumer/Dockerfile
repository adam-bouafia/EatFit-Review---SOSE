FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

COPY target/${JAR_FILE} EatFit-ReviewEditor-prosumer.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/EatFit-ReviewEditor-prosumer.jar"]