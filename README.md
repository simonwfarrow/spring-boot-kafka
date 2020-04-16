# spring-boot-kafka

1. Build docker image with "docker build -t spring-boot-kafka ."
2. Deploy to kuberenetes with "kubectl apply -f Deployment.yml"
3. Create service using "kubectl apply -f Service.yml"

Assumes this guide has been followed to setup Kafka cluster on Kubernetes: https://technology.amis.nl/2019/03/24/running-apache-kafka-on-minikube/
