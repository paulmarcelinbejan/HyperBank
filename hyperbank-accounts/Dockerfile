FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-accounts.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-accounts.jar

COPY config/* config/

EXPOSE 9001

CMD java -jar hyperbank-accounts.jar --spring.config.import=config/application-accounts.yaml --spring.profiles.include=env_local