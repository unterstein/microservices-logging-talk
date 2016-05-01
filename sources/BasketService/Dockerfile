FROM microservicelogging/servicebase
MAINTAINER Johannes Unterstein <unterstein@me.com>

EXPOSE 8081
RUN mkdir /app && \
	rm /opt/logstash/conf.d/nginx.conf

ADD target/BasketService-1.0-SNAPSHOT.jar /app/
ADD run.sh /root/run.sh
CMD /root/run.sh
