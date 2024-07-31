# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven/Gradle wrapper and related files
COPY mvnw* ./
COPY .mvn .mvn

# Copy the pom.xml file and download dependencies
COPY pom.xml ./
RUN ./mvnw dependency:go-offline

# Copy the project files
COPY src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Run the application
CMD ["java", "-jar", "target/your-app-name.jar"]