FROM microservicelogging/servicebase
MAINTAINER Johannes Unterstein <unterstein@me.com>

EXPOSE 8081
RUN mkdir /app && \
	rm /opt/logstash/conf.d/nginx.conf

ADD target/ArticleService-1.0-SNAPSHOT.jar /app/
CMD java -jar /app/ArticleService-1.0-SNAPSHOT.jar
