FROM gradle:latest AS builder

WORKDIR /app

COPY . .

RUN gradle build --no-daemon


FROM openjdk:17-ea-17-jdk-slim

EXPOSE 8080

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
HEALTHCHECK --start-period=10s --interval=5s --timeout=3s \
    CMD curl -f http://localhost:8080/actuator/health || exit 1
