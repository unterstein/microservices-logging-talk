#!/bin/bash

screen -S logstash -d -m /root/logstash.sh

java -jar /app/CheckoutService-1.0-SNAPSHOT.jar
