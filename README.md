# Abstract
## Deutsch
Die meisten von uns werden an einer Software arbeiten, welches auf mehrere Services, Systeme und/oder Server bzw. Rechenzentren verteilt ist. In verteilten Systemen fallen naturgemäß auch verteilte Logs an, welche aber am Besten über eine API durchsuchbar und monitorbar sein sollten. Der Stack mit Elasticsearch, Logstash und Kibana (ELK) ist üblich um diese Problematik zu adressieren und bietet eine wunderbare Basis für unsere Infrastruktur.

In dieser Session wird exemplarisch gezeigt wie man ELK in seine bestehende Service-Architektur integrieren kann um den bestmöglichen Einblick in seine Anwendung zu erhalten. Dabei werden Logs aus verschiedenen Anwendungen nach Elastic schreiben und mit kleinen Tricks service-übergreifende Semantik und Nachvollziehbarkeit erreicht. Dabei werden wir sehen, wie uns Dashboards für verschiedene Stakeholder (Sales, Marketing, Ops, Devs, ..) quasi geschenkt werden. Und das coolste dabei: Unsere bestehende Services werden gar nicht viel davon mitbekommen :-)


## English
Most of us build software, which is distributed on multiple services, systems or datacenters. Distributed systems produce distributed log files, but actually we need a centralized API to monitor and search this log files. The stack with elasticsearch, logstash and kibana (ELK) is well accepted to solve these issues and offers good starting point for our architecture.We demo in this session how to integrate the ELK stack to your existing service architecture to achieve the best monitoring experience of your application. We will sync different kinds of logs to elasticsearch and show some tricks how to enable service comprehensive semantics and traceability. Additionally we show how to build dashboards for different stakeholders (Sales, Marketing, Ops, Devs, …). But the best part of it: Our services will not recognize the new logging infrastructure :-)

# Talk

To see the presentation, just open the pdf file in the presentation folder or go to https://speakerdeck.com/unterstein/logging-in-the-era-of-microservices

# What is in this demo?
- Three services, bundled together with docker-compose
- A web app consuming this services
- One elasticsearch installation
- One kibana installation, consuming the elasticsearch api

The log files of the three services and the web app are synchronized to elasticsearch


# Get this demo working
- You need java, docker and docker-compose to be installed on your machine.
- Go to sources and run this command

```
./sources/buildAll.sh && ./sources/run.sh
```

- Point a browser of your choice to your docker ip on port ```8080``` for http to view the web app or port ```5601``` for http to view kibana. Before using kibana it would be good to generate some log files, using the web app :-)

# kibana-exported.json
Like described in the talk, I used ```elasticdump``` to export kibana dashboard and visualization. In the file ```kibana-exported.json``` the example sales dashboard is exported. I used the following command to export this dashboard:

```
elasticdump --input=http://localdock:9200/.kibana --output=$ --type=data  > kibana-exported.json
```

Previously I installed ```elasticdump``` using ```npm install -g elasticdump```

