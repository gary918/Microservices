# Build Microservices using Dapr on Azure
## Introduction to the Sample Solution
## Architecture Design
## Instructions
### Run Eshop
### Run Catalogue
```
dapr run --app-id catalogue --app-port 3000 --dapr-http-port 3500 node index.js
```
### Run Order

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.3/maven-plugin/reference/html/#build-image)

```
curl -X POST localhost:8080/product/add -H 'Content-type:application/json' -d '{"id": 100, "name": "gardener"}'
curl -X POST localhost:8080/product/add -H 'Content-type:application/json' -d '{"id": 101, "name": "mom1"}'
curl -X GET localhost:8080/product/listall
```

## References
* [Dapr](https://dapr.io/)
* [eShop on Dapr](https://github.com/dotnet-architecture/eShopOnDapr)
<<<<<<< HEAD
* [Spring WebClient vs. RestTemplate](https://www.baeldung.com/spring-webclient-resttemplate)
* [5 ways to make HTTP requests in Java](https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java)
=======
* [Open Service Mesh](https://docs.microsoft.com/en-us/azure/aks/servicemesh-osm-about?pivots=client-operating-system-linux)
>>>>>>> e24cf7598d7812a67ce7b0340bb87d14cb3c03e9
