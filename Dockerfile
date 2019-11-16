FROM openjdk:8-jdk-alpine

LABEL maintainer="baroninet@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/bravi-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} bravi.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bravi.jar"] 		
