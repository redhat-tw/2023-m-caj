# Charts
用於佈署 CAJ 應用之 Helm Chart.

* 預設之 Values.yaml
```yaml=
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

* 佈署
```bash=
# 佈署前先登入 OpenShift，登入後切換至欲佈署的專案
helm install caj-apps ./caj-apps
```

* 移除
```bash=
helm uninstall caj-apps
```