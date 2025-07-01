# Stage 1: build
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

# Copia pom.xml e la cartella src
COPY pom.xml .
COPY src ./src

# Costruisci il progetto saltando i test
RUN mvn clean package -DskipTests

# Stage 2: esecuzione
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia il jar costruito dal primo stage
COPY --from=build /app/target/bibliotecaScolastica-service-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta 8080
EXPOSE 8080

# Comando di avvio
ENTRYPOINT ["java", "-jar", "app.jar"]
