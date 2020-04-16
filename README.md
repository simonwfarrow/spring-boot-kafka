# spring-boot-kafka

The purpose of this repo was to learn:

1. How to run and deploy containers to Kubernetes locally
2. How to run a Kafka cluster on Kubernetes
3. How to dockerise a java application to run on Kubernetes, making use of the Kafka cluster

The Spring application code in this repo was replicated from this [guide](https://www.confluent.io/blog/apache-kafka-spring-boot-application/)

## Pre-req
1. Minikube is configured and running.
2. This guide has been followed to setup Kafka cluster on Kubernetes: [guide](https://technology.amis.nl/2019/03/24/running-apache-kafka-on-minikube/)

## Setup
1. Build docker image with "docker build -t spring-boot-kafka ."
2. Deploy to kuberenetes with "kubectl apply -f Deployment.yml"
3. Create service using "kubectl apply -f Service.yml"

## Config
Kafka config is stored in Springs application.properties file in the resources folder. Uses the kafka service in the kafka-ca1 namespace to connect to the brokers.
Deployment is set to 3 pods.

## Execution
1. Get minikube IP address via "minikube ip".
2. Get external service port for Spring web app via "kubectl get svc" -> ```spring-boot-service        NodePort    10.98.95.188    <none>        9000: --->32086<---- /TCP   65m```
3. Post a request to http://${minikubeip}:${externalport}/kafka/publish?message=hello
4. View Pod logs to see which Pod recieved the request and produced the message and which Pod consumed the message
