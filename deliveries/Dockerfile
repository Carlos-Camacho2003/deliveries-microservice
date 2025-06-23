# Etapa de construcción
FROM maven:3.9.7-eclipse-temurin-17 AS build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia el JAR construido
COPY --from=build /workspace/app/target/deliveries-*.jar app.jar

# Puerto expuesto
EXPOSE 9090

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]