# An example of Spring Boot service written in Kotlin
Uses Spring Boot 5, Java 11, Kotlin 1.3

### Done:
* Gradle build
* Model
* REST API
* SOAP API
* Stub implementation
* OpenAPI Spec + Swagger UI
* "External" SOAP service invocation using CXF
* MapStruct
* "External" REST service invocation using WebClient
* SpEL Gates
* Async SOAP invocation
* Merge 2 async responses using Reactor

### To do:
* Add logging, for God's sake!
* Error handling in async actions
* ~~Hystrix~~ Resilience4j
* Base UI 
* Tests
* Docker-compose to run the whole thing

### Try:
* "External" SOAP service invocation using Web Client's Soap Async API (what's it called?) instead of generated WSDL methods
* Coroutines instead of reactive pipes (https://stackoverflow.com/questions/55684117/how-to-return-a-kotlin-coroutines-flow-in-spring-reactive-webclient)

### How to start
1. Run mock
2. Run service with -Dservice.timeout=1000 -Dservice.systemAEndpoint=http://localhost:8090/soap-api/system-a -Dservice.systemBUrl=http://localhost:8090

### Thanks
[@AnkBurov]( https://github.com/AnkBurov )