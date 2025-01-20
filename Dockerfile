#FROM ubuntu:latest
FROM openjdk:21-jdk-slim
#LABEL authors="eroskollerdev"

MAINTAINER eroskoller.com

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

#EXPOSE 8080
