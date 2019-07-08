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

### To do:
* Add SpEL Gates
* "External" REST service invocation using WebClient
* Merge 2 async responses using Reactor
* ~~Hystrix~~ Resilience4j
* Base UI 
* Tests
* Docker-compose to run the whole thing

### Try:
* "External" SOAP service invocation using Soap Async API (what's it called?)
* Coroutines instead of reactive pipes (https://stackoverflow.com/questions/55684117/how-to-return-a-kotlin-coroutines-flow-in-spring-reactive-webclient)

### Thanks
[@AnkBurov]( https://github.com/AnkBurov )