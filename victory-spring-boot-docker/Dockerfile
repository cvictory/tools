FROM openjdk:8-jdk-alpine
MAINTAINER victory
VOLUME /tmp
ARG DEPENDENCY=victory-spring-boot-docker
COPY target/victory-spring-boot-docker-0.0.1-SNAPSHOT.jar target/victory-spring-boot-docker-0.0.1-SNAPSHOT.jar

COPY start.sh /usr/local/bin/start.sh

EXPOSE 8888
EXPOSE 7777

RUN chmod 777 /usr/local/bin/start.sh

ENTRYPOINT ["start.sh"]
