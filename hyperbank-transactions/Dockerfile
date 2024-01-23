FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-transactions.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-transactions.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-transactions.jar --spring.config.import=config/application-transactions.yaml --spring.profiles.include=env_docker