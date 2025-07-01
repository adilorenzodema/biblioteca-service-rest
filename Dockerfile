# Stage 1: build
FROM maven:3.8.7-openjdk-17 AS build

WORKDIR /app

# Copia i file necessari per buildare
COPY pom.xml .
COPY src ./src

# Build del jar (skip tests per velocizzare)
RUN mvn clean package -DskipTests

# Stage 2: esecuzione
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia il jar dalla build precedente
COPY --from=build /app/target/bibliotecaScolastica-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
