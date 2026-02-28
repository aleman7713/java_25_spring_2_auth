# FROM openjdk:8-jdk-alpine       # not found
FROM openjdk:24-ea-11-oracle

EXPOSE 8080

COPY target/java_25_spring_2_auth-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]