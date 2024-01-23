FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-types.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-types.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-types.jar --spring.config.import=config/application-types.yaml --spring.profiles.include=env_docker