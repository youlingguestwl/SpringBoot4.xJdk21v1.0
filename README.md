# Spring Boot 4.x + JDK 21 (跟python交互)

## 启动工程 DemoApplication.java

## 通过终端命令进行访问

- test
```shell
 curl -X GET "http://localhost:8080/hello"
```

- register
```shell
  curl -X POST "http://localhost:8080/register" \
   -H "Content-Type: application/json" \
  -d '{"username":"zhangsan1","password":"123","email":"zhangsan@qq.com"}'
```

- login

````shell
curl -X POST "http://localhost:9080/login" \
   -H "Content-Type: application/json" \
  -d '{"username":"youling","password":"123456"}'
````


## Docker部署

- 修改application.yaml文件

````yaml
#url: http://localhost:8000
# 容器修改
url: http://demo-backend:8000
````

````shell
docker build -t dspringboot4_jdk21_python_integration_demo-backend:1.0 .
````


```shell
docker run -d -p 9080:9080 --network some-network --name my-spring-app -e SERVER_PORT=9080 \
dspringboot4_jdk21_python_integration_demo-backend:1.0
```

- 测试

```shell
curl -X POST "http://localhost:9080/login" \
   -H "Content-Type: application/json" \
  -d '{"username":"youling","password":"123456"}'
```

```shell
  curl -X POST "http://localhost:9080/register" \
   -H "Content-Type: application/json" \
  -d '{"username":"youling","password":"123456","email":"1@163.com"}'
```