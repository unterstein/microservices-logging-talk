#!/bin/bash

cd $(dirname $0)

cd ArticleService
mvn clean install
docker build -t articleservice:latest .
cd ..

cd BasketService
mvn clean install
docker build -t basketservice:latest .
cd ..

cd CheckoutService
mvn clean install
docker build -t checkoutservice:latest .
cd ..

cd WebService
docker build -t webservice:latest .
cd ..
