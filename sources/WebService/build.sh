#!/bin/bash

cd $(dirname $0)

docker build -t microservicelogging/webservice:latest .
