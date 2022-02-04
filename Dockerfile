FROM openjdk:8
#WORKDIR /usr/java-kotlin-rest-api
ARG JAR_FILE=*.jar
COPY build/libs/sb-kotlin-java-app-0.1.jar sb-kotlin-java-app-0.1.jar

#COPY ormconfig.docker.json ./ormconfig.json

EXPOSE 8080 8081 5432 5440

ADD build/libs/sb-kotlin-java-app-0.1.jar sb-kotlin-java-app-0.1.jar
ENTRYPOINT ["java", "-jar", "sb-kotlin-java-app-0.1.jar"]
