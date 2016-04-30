FROM java:8-jre
MAINTAINER Johannes Unterstein <unterstein@me.com>

EXPOSE 8081
RUN mkdir /app
COPY target/CheckoutService-1.0-SNAPSHOT.jar /app/
CMD java -jar /app/CheckoutService-1.0-SNAPSHOT.jar
