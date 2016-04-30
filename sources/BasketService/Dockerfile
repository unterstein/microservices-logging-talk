FROM java:8-jre
MAINTAINER Johannes Unterstein <unterstein@me.com>
EXPOSE 8081
RUN mkdir /app
COPY target/BasketService-1.0-SNAPSHOT.jar /app/
CMD java -jar /app/BasketService-1.0-SNAPSHOT.jar
