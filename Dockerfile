FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY /.target/demo-workshop-2.0.2.jar /usr/app/
WORKDIR /usr/app

CMD java -jar demo-workshop-*.jar

