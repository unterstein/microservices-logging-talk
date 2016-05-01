FROM ubuntu:16.04
MAINTAINER Johannes Unterstein <unterstein@me.com>

ENV DEBIAN_FRONTEND noninteractive

# install java
RUN apt-get update && \
	apt-get install -y software-properties-common && \
  	echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  	add-apt-repository -y ppa:webupd8team/java && \
  	apt-get update && \
  	apt-get install -y oracle-java8-installer && \
  	rm -rf /var/cache/oracle-jdk8-installer


# install logstash
ADD logstash-2.3.2.tar.gz /opt
RUN ln -s /opt/logstash-2.3.2 /opt/logstash
ADD conf.d/ /opt/logstash/conf.d/
ADD logstash.sh /root/logstash.sh
