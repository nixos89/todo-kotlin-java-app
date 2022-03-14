FROM openjdk:8

COPY . .

RUN chmod +x ./gradlew && chmod +x ./wait-for-it.sh

RUN ./gradlew clean build

EXPOSE 8080

# might need to place only ENTRYPOINT and invoked CMD in docker-compose.yml file as `command` property
ENTRYPOINT ["java",  "-jar", "./build/libs/sb-kotlin-java-app-0.1.jar"]
#CMD ["/wait-for-it.sh" , "postgres-db:5432" , "--strict" , "--timeout=150" , "--" , "java -jar ./build/libs/sb-kotlin-java-app-0.1.jar"]