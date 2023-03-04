FROM openjdk:17-ea-17-jdk-slim

EXPOSE 8080

COPY /build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]