# spring-boot-security-example

用 **maven** 编译打包运行项目
```console
$ mvn clean package spring-boot:run
```

创建用户
```console
$ curl http://127.0.0.1:8080/authentication/register -H "Content-type: application/json" -X POST -d '{ "username": "vincent", "password": "vincent" }'
{"id":1,"username":"vincent5","password":"$2a$10$uEr55195zaI7X/u2lLgpneeCMHvfxaxZVGaC/IWYAaFOXw.vTNEHW"}
```

用户登录，登录成功之后会返回 **token**
```console
$ curl http://127.0.0.1:8080/authentication -H "Content-type: application/json" -X POST -d '{ "username": "vincent", "password": "vincent" }'
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5jZW50MSIsImV4cCI6MTUyOTQ1OTE2NywiaWF0IjoxNTI4ODU0MzY3fQ.Tb18MiFExLbmGX6kphunEUY85nsgdBr46YggTgljkJJsLurJmj3NmWEVyb7DosXmlMfCBihZFX4yjLuGE-4ldg
```

不带 **token** 访问接口，会返回 **403** 状态码
```console
$ curl http://127.0.0.1:8080/user/1
{"timestamp":"2018-06-13T01:51:19.630+0000","status":403,"error":"Forbidden","message":"Access Denied","path":"/user/1"}
```

访问 `/user/{id}` 接口，注意带上 **token**，访问成功可以看到返回数据
```console
$ curl http://127.0.0.1:8080/user/1 -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aW5jZW50MSIsImV4cCI6MTUyOTQ1OTE2NywiaWF0IjoxNTI4ODU0MzY3fQ.Tb18MiFExLbmGX6kphunEUY85nsgdBr46YggTgljkJJsLurJmj3NmWEVyb7DosXmlMfCBihZFX4yjLuGE-4ldg"
{"id":1,"username":"vincent","password":"vincent"}
```