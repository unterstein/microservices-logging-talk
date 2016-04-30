#!/bin/bash

cd $(dirname $0)

./ServicesBaseImage/build.sh

./buildServices.sh

./WebService/build.sh
./ElasticSearch/build.sh
