FROM eclipse-temurin:17-jdk-alpine AS build

RUN apk add --no-cache bash procps curl tar

ENV MAVEN_HOME /usr/share/maven

COPY --from=maven:3.9.6-eclipse-temurin-11 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ARG MAVEN_VERSION=3.9.6
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

WORKDIR /app

COPY . ./

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app

COPY --from=build /app/target/nord-crm-api-0.0.1-SNAPSHOT.jar /app/target/nord-crm-api-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD java -jar /app/target/nord-crm-api-0.0.1-SNAPSHOT.jar --server.port=8080
#RUN touch debug.log
#CMD tail -f debug.log
