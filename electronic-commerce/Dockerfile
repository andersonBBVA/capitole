

FROM maven:3.8.6-eclipse-temurin-17-alpine AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-slim-buster

COPY --from=build /home/app/target/electronic-commerce-1.0.0.jar /usr/local/lib/capitole-technical-test-pricing-api-0.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/capitole-technical-test-pricing-api-0.jar"]