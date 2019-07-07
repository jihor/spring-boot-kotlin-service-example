FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.3_7
MAINTAINER "jihor"

# add jar
ADD /example-service.jar /

EXPOSE 8080

# setup startup command
CMD ["bash", "-c", "java -jar  \
     ${JAVA_OPTS} \
     -Dserver.port=$SERVER_PORT \
     /example-service.jar"]
