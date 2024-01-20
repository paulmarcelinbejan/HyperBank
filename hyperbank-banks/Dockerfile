FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-banks.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-banks.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-banks.jar --spring.config.import=config/application-banks.yaml --spring.profiles.include=env_local