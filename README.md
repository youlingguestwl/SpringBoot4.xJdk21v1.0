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
  -d '{"username":"zhangsan1","password":"1","email":"zhangsan@qq.com"}'
```

- login

````shell
curl -X POST "http://localhost:8080/login" \
   -H "Content-Type: application/json" \
  -d '{"username":"zhangsan1","password":"1"}'
````