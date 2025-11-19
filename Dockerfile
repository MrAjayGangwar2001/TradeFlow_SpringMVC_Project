# Stage 1: Build the JAR
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw

# Copy source code
COPY src ./src

# Build project
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Run using Render's PORT
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
