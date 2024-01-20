FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-interests.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-interests.jar

COPY config/* config/

EXPOSE 9003

CMD java -jar hyperbank-interests.jar --spring.config.import=config/application-interests.yaml --spring.profiles.include=env_local