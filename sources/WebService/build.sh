#!/bin/bash

cd $(dirname $0)

docker build -t unterstein/webservice:latest .
