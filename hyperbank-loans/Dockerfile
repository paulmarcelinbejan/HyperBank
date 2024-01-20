FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-loans.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-loans.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-loans.jar --spring.config.import=config/application-loans.yaml --spring.profiles.include=env_local