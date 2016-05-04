#!/bin/bash

cd $(dirname $0)

./ServiceBaseImage/build.sh

./buildServices.sh
