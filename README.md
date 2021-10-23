# COLLECTOR-SERVICE

Fraction battle collector service

## Installation

1. use JDK-17
2. create fb database
3. run application (flyway will create scheme and other tables)

### Install docker and minikube

1. install docker desktop (`https://docs.docker.com/desktop/windows/install/`)
2. install minikube (`https://kubernetes.io/ru/docs/tasks/tools/install-minikube/`)
3. install helm

### build image and run inside minikube

1. run: `minikube start --vm-driver=docker`
2. run: `minikube docker-env; minikube -p minikube docker-env | Invoke-Expression`
3. run: `./gradlew jibDockerBuild`

### run application inside kubernetes

1. locate yourself inside helm directory: `cd helm`
2. install chart: `helm install collector ./collector`
   to upgrade: `helm upgrade collector ./collector`
   to delete: `helm delete collector`