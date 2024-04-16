FROM openjdk:8
COPY build/libs/sb-kotlin-java-app-0.1.jar /app/sb-kotlin-java-app-0.1.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
#COPY ormconfig.docker.json ./ormconfig.json

EXPOSE 8080 8081 5432 5440

ADD build/libs/sb-kotlin-java-app-0.1.jar sb-kotlin-java-app-0.1.jar
ADD ./wait-for-it.sh wait-for-it.sh

# TODO: fix CMD/ENTRYPOINT for wait-for-it script so following error does NOT occur:
#nikola@ns-dell3537:~/IntellIJIDEA_WS/first-java-kotlin-gradle-project$ docker run -p 8080:8080 nixos89/sb-kotlin-java-app
#Error: you need to provide a host and port to test.
#Usage:
#    wait-for-it.sh host:port [-s] [-t timeout] [-- command args]
#    -h HOST | --host=HOST       Host or IP under test
#    -p PORT | --port=PORT       TCP port under test
#                                Alternatively, you specify the host and port as host:port
#    -s | --strict               Only execute subcommand if the test succeeds
#    -q | --quiet                Don't output any status messages
#    -t TIMEOUT | --timeout=TIMEOUT
#                                Timeout in seconds, zero for no timeout
#    -- COMMAND ARGS             Execute command with args after the test finishes


ENTRYPOINT [ "/bin/bash", "-c" ]
# modify 2nd argumet in next (i.e. `CMD`) line
CMD ["/wait-for-it.sh" , "[localhost:5432]" , "--strict" , "--timeout=300" , "--" , "java -jar /app/sb-kotlin-java-app-0.1.jar"]
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/sb-kotlin-java-app-0.1.jar"]
