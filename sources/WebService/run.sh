#!/bin/bash

screen -S logstash -d -m /root/logstash.sh

nginx -g "daemon off;"
