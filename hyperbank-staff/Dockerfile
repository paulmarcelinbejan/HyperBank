FROM eclipse-temurin:17-jre-jammy

MAINTAINER Paul Marcelin Bejan <paulmarcelinbejan.developer@gmail.com>

ARG JAR_FILE=target/hyperbank-staff.jar

WORKDIR /home/

RUN mkdir config

COPY ${JAR_FILE} hyperbank-staff.jar

COPY config/* config/

EXPOSE 9002

CMD java -jar hyperbank-staff.jar --spring.config.import=config/application-staff.yaml --spring.profiles.include=env_local