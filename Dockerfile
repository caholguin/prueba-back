# Usa una imagen base de Java
FROM openjdk:19-jdk-alpine3.16

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado por Spring Boot al contenedor
COPY target/spring-security-0.0.1-SNAPSHOT.jar /app/mi-aplicacion.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]
