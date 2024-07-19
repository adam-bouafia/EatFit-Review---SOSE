FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

COPY target/${JAR_FILE} EatFit-FoodSearch-Prosumer.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/EatFit-FoodSearch-Prosumer.jar"]