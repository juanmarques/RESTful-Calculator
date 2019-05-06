# RESTful-Calculator

#### Run in docker container
```
cd .\RESTful-Calculator\

./mvnw clean install dockerfile:build

docker run -d -p 8080:8080 calculator-api:latest to silent mode

docker run -p 8080:8080 calculator-api:latest to listen the application

```

#### Stop the container
```
docker rm <containerID> -f
```

#### Run local without docker
```

cd .\RESTful-Calculator\

./mvnw spring-boot:run

```

#### Run tests with maven
cd .\RESTful-Calculator\

./mvnw test

####Endpoint
```
http://localhost:8080/api/calculator/add?firstValue=1&secondValue=1
http://localhost:8080/api/calculator/divide?firstValue=1&secondValue=1
http://localhost:8080/api/calculator/multiply?firstValue=1&secondValue=1
http://localhost:8080/api/calculator/subtract?firstValue=1&secondValue=1
http://localhost:8080/api/calculator/fibbonachi/8
```
#### Technologies

* Java 8
* Spring Boot 2.1.4
* Spring AOP
* Lombok
* Junit
* Mockito
* rest-assured
* Eclipse
* Docker