# Usa una imagen base de Java
FROM openjdk:19-jdk-alpine3.16

WORKDIR /app

COPY target/spring-security-0.0.1-SNAPSHOT.jar /app/mi-aplicacion.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]