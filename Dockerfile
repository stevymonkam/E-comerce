FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
