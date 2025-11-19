# Step 1: Build the jar using Maven Wrapper
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy everything
COPY . .

# Give executable permission to mvnw (Linux command)
RUN chmod +x mvnw

# Build project
RUN ./mvnw clean package -DskipTests


# Step 2: Run the Spring Boot application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
