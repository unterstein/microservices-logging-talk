#!/bin/bash

cd $(dirname $0)

./ArticleService/build.sh
./BasketService/build.sh
./CheckoutService/build.sh
./WebService/build.sh
