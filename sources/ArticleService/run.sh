#!/bin/bash

screen -S logstash -d -m /root/logstash.sh

java -jar /app/ArticleService-1.0-SNAPSHOT.jar
