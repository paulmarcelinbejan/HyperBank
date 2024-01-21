FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-config-provider.jar

WORKDIR /home/

RUN mkdir config

RUN mkdir cloud_config

COPY ${JAR_FILE} hyperbank-banks.jar

COPY config/* config/

COPY cloud_config/* cloud_config/

EXPOSE 8888

CMD java -jar hyperbank-banks.jar --spring.config.import=config/application-config-provider--local.yaml