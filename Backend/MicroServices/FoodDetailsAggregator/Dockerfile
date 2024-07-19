FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

COPY target/${JAR_FILE} Eatfit-FoodDetailsAggregator-microservicess.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Eatfit-FoodDetailsAggregator-microservicess.jar"]