# 前端服務
CAJ 使用之前端服務

## Image 位置
```
quay.io/ske/m-caj-mock-tvm
```

## 環境變數

/src/asset/config.json 決定前端程式呼叫後端服務之所在位置，預設值如下，佈署時透過 `ConfigMap` 注入，注入方法詳見 `deployment` 資料夾
```
{
  "masterfileURL":"http://localhost:8080",
  "reservationURL":"http://localhost:8084",
  "scheduleURL":"http://localhost:8082"
}
```

## 應用建置
1. 建置 Artifact
```bash=
npm i
npm i primeflex
ng build
```

2. 啟動應用
```bash=
ng serve
```


## 容器化
1. 建置容器 
```bash=
# http 8080 port
podman build -f Containerfile -t m-caj-mock-tvm:latest .
```

```bash=
# https 8443 port 含字簽憑證 
podman build -f Containerfile-tls -t m-caj-mock-tvm:tls .
```

2. 啟動容器
```bash=
# http 8080 port
podman run -p 8080:8080 m-caj-mock-tvm:latest
```

```bash=
# https 8443 port 含自簽憑證
podman run -p 8443:8443 m-caj-mock-tvm:tls
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
