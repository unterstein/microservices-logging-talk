FROM microservicelogging/servicebase
MAINTAINER Johannes Unterstein <unterstein@me.com>

RUN apt-get install -y nginx && \
	rm /opt/logstash/conf.d/jooby.conf

ADD markup /usr/share/nginx/html
ADD nginx/nginx.conf /etc/nginx/
ADD nginx/conf.d/default.conf /etc/nginx/conf.d/
ADD run.sh /root

CMD ["/root/run.sh"]