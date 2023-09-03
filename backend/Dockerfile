# Creating build with the docker file
# From https://spring.io/guides/topicals/spring-boot-docker/#Multi-Stage%20Build

# Build stage
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

# Copy Maven executable and dependency definitions
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src src

# Build the project and skip tests
RUN ./mvnw install -DskipTests

# Extract the JAR
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

# Set the location of the dependency directory from the build stage
ARG DEPENDENCY=/workspace/app/target/dependency

# Copy the content from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Define the entrypoint of the application with env prod
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-cp","app:app/lib/*","com.example.itjobs.ItJobsApplication"]
