# 2023-m-caj
Repository for 2023 Container Adoption Journey.

## 資料夾說明

| No |  資料夾 | 說明 | Image 位置 |
| -------- | -------- | -------- | -------- |
| 1     | demo-app     | 用於練習 podman 操作之應用     |quay.io/ske/demo-app|
| 2     | k8s-troubleshooting     | 用於練習 k8s 操作之情境     | N/A |
| 3     | k8s-voting-app     | 於練習 k8s 操作之應用     | N/A |
| 4     | charts     | CAJ 應用之 Helm Chart     | N/A |
| 5     | mock-tvm     | 前端應用    | quay.io/ske/m-caj-mock-tvm|
| 6     | mono-backend     | 單體後端   |quay.io/ske/m-caj-mono-backend |
| 7     | masterfile     | 主檔服務     |quay.io/ske/m-caj-masterfile |
| 8     | reservation     | 訂位服務     | quay.io/ske/m-caj-reservation|
| 9     | schedule     | 時刻表服務     | quay.io/ske/m-caj-schedule|
| 10     | fare     | 票價服務     | quay.io/ske/m-caj-fare|
| 11     | payment     | 支付服務     | quay.io/ske/m-caj-payment|


## 服務拓墣
本服務將演示由單體式架構拆分為微服務的結果，並運行於 OpenShift 上。

![](https://hackmd.io/_uploads/rJjoNeo-T.png)

## 快速佈署
1. 切換至 Charts 目錄
```bash
cd charts
```

2. 依照需求先改好 values.yaml

```yaml=
# 預設之 Values.yaml
# Basic Config
studentId: speaker01
project: speaker01-green
clusterAppsDomain: apps.cluster-zghzl.zghzl.sandbox852.opentlc.com
image:
  repository: quay.io/ske
# Service Config
masterfileURL: http://m-caj-masterfile:8080
fareURL: http://m-caj-fare:8080
paymentURL: http://m-caj-payment:8080
membershipURL: http://m-caj-payment:8080
# DB Config
db:
  dialect: org.hibernate.dialect.H2Dialect
  driver: org.h2.Driver
  url: 'jdbc:h2:mem:lab;DB_CLOSE_DELAY=-1'
  user: sa
  pxd: c2E=
```

3. 登入 OpenShift
```bash=
# 登入
oc login ${API_SERVER}
# 切換專案
oc project ${PROJECT_NAME}
```

4. 佈署
```bash=
helm install caj-apps ./caj-apps
```

5. 移除
```bash=
helm uninstall caj-apps
```