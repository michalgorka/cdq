FROM maven:3.8.3-openjdk-17 AS builder

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn package

FROM openjdk:17-slim

COPY --from=builder target/cdq-1.0.0.jar app.jar

EXPOSE 9999
ENTRYPOINT ["java","-jar","/app.jar"]