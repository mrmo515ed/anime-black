FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy Gradle wrapper and build files (will be provided in repo)
COPY . /app

# Use Gradle wrapper to build the jar
RUN ./gradlew -p backend clean build -x test --no-daemon

# Run the fat jar produced by application plugin
CMD ["java", "-jar", "backend/build/libs/backend-all.jar"]
