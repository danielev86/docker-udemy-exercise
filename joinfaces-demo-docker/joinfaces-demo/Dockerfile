FROM openjdk:8-jdk-alpine
MAINTAINER danielev86.com
ARG JAR_VERSION
COPY target/joinfaces-demo-${JAR_VERSION} joinfaces-demo.jar
ENTRYPOINT ["java", "-jar", "joinfaces-demo.jar"]