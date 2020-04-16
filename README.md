# spring-boot-kafka

## How to run:
1. Build docker image with "docker build -t spring-boot-kafka ."
2. Deploy to kuberenetes with "kubectl apply -f Deployment.yml"
3. Create service using "kubectl apply -f Service.yml"

## Config
Kafka conifg is stored in Springs application.properties file in the resources folder. Uses the kafka service in the kafka-ca1 namespace to connect to the brokers.
Deployment is set to 3 pods.

## Assumptions
Assumes this guide has been followed to setup Kafka cluster on Kubernetes: https://technology.amis.nl/2019/03/24/running-apache-kafka-on-minikube/
