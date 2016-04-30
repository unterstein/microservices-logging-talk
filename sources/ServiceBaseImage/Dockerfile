FROM java:8-jre
MAINTAINER Johannes Unterstein <unterstein@me.com>

ADD https://download.elastic.co/logstash/logstash/logstash-2.3.2.tar.gz /opt
RUN ln -s /opt/logstash-2.3.2 /opt/logstash
ADD conf.d/ /opt/logstash/conf.d/
ADD logstash.sh /root/logstash.sh
