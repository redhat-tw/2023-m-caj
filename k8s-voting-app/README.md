# Kuberentes Voting Application Example
This example is based on the original [example-voting-app](https://github.com/dockersamples/example-voting-app) repository from the dockersamples GitHub page.

## Requirement
* Kubernetes Cluster 1.23+

## Architecture
![Kubernetes Voting Application](./img/k8s-voting-app.png)

## Quick Start
1. Deploy a database service.
```bash
$ kubectl create -f db/
```
2. Deploy a redis service.
```bash
$ kubectl create -f redis/
```
3. Deploy backend services.
```bash
$ kubectl create -f backend/
```

4. Deploy frontend servces.
```bash
$ kubectl create -f frontend/
```

5. Access the voting application

Voting Page
```
http://vote-${STUDENT_ID}-ing.apps.cluster-r7w8k.r7w8k.sandbox930.opentlc.com
```
Voting Result Page
```
http://result-${STUDENT_ID}-ing.apps.cluster-r7w8k.r7w8k.sandbox930.opentlc.com
```

## Cleanup
To remove the voting application, execute the following commands:
```
$ cd 2023-m-caj/k8s-voting-app
$ kubectl delete -f frontend/
$ kubectl delete -f backend/
$ kubectl delete -f redis/
$ kubectl delete -f db/
```