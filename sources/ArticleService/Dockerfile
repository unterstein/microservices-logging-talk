FROM java:8-jre
MAINTAINER unterstein@me.com
EXPOSE 8081
RUN mkdir /app
COPY target/ArticleService-1.0-SNAPSHOT.jar /app/
CMD java -jar /app/ArticleService-1.0-SNAPSHOT.jar
