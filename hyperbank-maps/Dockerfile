FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-maps.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-maps.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-maps.jar --spring.config.import=config/application-maps.yaml --spring.profiles.include=env_local