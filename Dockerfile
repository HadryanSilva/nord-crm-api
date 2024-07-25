FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn

RUN ./mvnw clean package

CMD ["java", "-jar", "/app/nord-crm-api-0.0.1-SNAPSHOT.jar"]