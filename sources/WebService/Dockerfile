FROM nginx:1.10
MAINTAINER Johannes Unterstein <unterstein@me.com>
EXPOSE 80
COPY markup /usr/share/nginx/html
COPY nginx/nginx.conf /etc/nginx/
COPY nginx/conf.d/default.conf /etc/nginx/conf.d/
