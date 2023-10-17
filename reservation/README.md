# 訂位服務
CAJ 使用之訂位服務

## Image 位置
```
quay.io/ske/m-caj-reservation
```

## 環境變數

| No | 變數 | 說明 | 預設值 |
| -------- | -------- | -------- | -------- |
| 1     | DB_DIALECT     | DB 語系     |org.hibernate.dialect.H2Dialect|
| 2     | DB_DRIVER     | DB 驅動程式     |org.h2.Driver|
| 3     | DB_URL     | DB 連線位置     |jdbc:h2:mem:lab;DB_CLOSE_DELAY=-1|
| 4     | DB_USER     | DB 使用者     |sa|
| 5     | DB_PXD     | DB 密碼     |sa|
| 6     | JAEGER_URI     | Jaeger 位置     |http://jaeger-collector.istio-system.svc:4318/v1/traces|
| 6     | MASTERFILE_URL     |  masterfile 服務位置，上 k8s 後要修改此變數為 masterfile 的 Service 名稱     |http://localhost:8080 |
| 6     | FARE_URL     |  fare 服務位置，上 k8s 後要修改此變數為 masterfile 的 Service 名稱     | http://localhost:8080|
| 6     | PAYMENT_URL     |  payment 服務位置，上 k8s 後要修改此變數為 masterfile 的 Service 名稱    | http://localhost:8080|
| 6     | MEMBERSHIP_URL     |  payment 服務位置(目前寫在 payment裡面)，上 k8s 後要修改此變數為 masterfile 的 Service 名稱     | http://localhost:8080|

## 應用基本資訊
* Health Check Endpoint
```
/actuator/health
```
* Prometheus Exporter
```
/actuator/prometheus
```

* Swagger UI
```
/swagger-ui.html
```

## 應用建置
1. 程式碼品質掃描
```bash=
mvn clean package sonar:sonar \
-Dsonar.projectKey=PROJECT_KEY \
-Dsonar.projectName='PROJECT_NAME' \ 
-Dsonar.host.url=http://localhost:9000 \ 
-Dsonar.token=THE_GENERATED_TOKEN
```

2. 建置 Java Artifact
```bash=
mvn clean package
ls target
```

3. 啟動應用
```bash=
# 預設 port 8080
java -jar target/reservation-0.0.1-SNAPSHOT.jar
```


## 容器化
1. 建置容器
```bash=
podman build -f Containerfile -t m-caj-reservation:latest .
```


2. 啟動容器
```bash=
podman run -p 8080:8080 m-caj-m-caj-reservation:latest
```

## 佈署於 OpenShift
```bash=
# 登入叢集
oc login ${CLUSTER}
# 切換專案
oc project ${PROJECR}
# Apply YAML
oc apply -f src/main/resources/openshift/
```