#!/bin/bash

cd $(dirname $0)

cd ServiceCommons
mvn clean install
cd ..

./ArticleService/build.sh
./BasketService/build.sh
./CheckoutService/build.sh
./WebService/build.sh
