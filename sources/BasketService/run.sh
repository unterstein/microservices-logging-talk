#!/bin/bash

screen -S logstash -d -m /root/logstash.sh

java -jar /app/BasketService-1.0-SNAPSHOT.jar
