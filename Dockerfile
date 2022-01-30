FROM openjdk:8 as builder
WORKDIR /usr/java-kotlin-rest-api
COPY . .

COPY ormconfig.docker.json ./ormconfig.json

EXPOSE 8080

ADD build/libs/sb-kotlin-java-app-0.1.jar sb-kotlin-java-app-0.1.jar
ENTRYPOINT ["java", "-jar", "build/libs/sb-kotlin-java-app-0.1.jar"]
