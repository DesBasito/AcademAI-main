FROM maven:3.9.8-amazoncorretto-21 AS build
WORKDIR /build
COPY src ./src
COPY pom.xml ./
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build /build/target/*.jar ./academai-0.0.1-SNAPSHOT.jar
EXPOSE 8081
CMD ["java", "-jar", "academai-0.0.1-SNAPSHOT.jar"]