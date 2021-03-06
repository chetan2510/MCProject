FROM maven:3.6.2-jdk-11-slim AS MAVEN_BUILD

COPY src src
COPY pom.xml pom.xml

WORKDIR .
RUN mvn clean install

FROM openjdk:latest

COPY --from=MAVEN_BUILD /target/mc-1.0.0-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/mc-1.0.0-SNAPSHOT.jar"]


#ARG JAR_FILE=/target/mc-1.0.0-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#
#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
#
#MAINTAINER Brian Hannaway
#
#COPY pom.xml /build/
#COPY src /build/src/
#
#WORKDIR /build/
#RUN mvn package
#
#FROM openjdk:8-jre-alpine
#
#WORKDIR /app
#
#COPY --from=MAVEN_BUILD /build/target/docker-boot-intro-0.1.0.jar /app/
#
#ENTRYPOINT ["java", "-jar", "docker-boot-intro-0.1.0.jar"]