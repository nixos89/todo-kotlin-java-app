FROM gradle:jdk8-jammy AS build
LABEL maintainer="Nikola Stevanovic <nixos89@gmail.com>"
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

# Example by https://dev.to/scaledynamics/deploy-a-spring-boot-kotlin-application-with-docker-4do3
FROM openjdk:8-jre-slim
COPY --from=build /home/gradle/src/build/libs/todo-app-0.1.jar /app/
RUN bash -c 'touch /app/todo-app-0.1.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/todo-app-0.1.jar"]
