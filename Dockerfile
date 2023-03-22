FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/E-comerce*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
