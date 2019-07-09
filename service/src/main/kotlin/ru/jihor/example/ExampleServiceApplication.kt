package ru.jihor.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import reactivefeign.spring.config.EnableReactiveFeignClients
import ru.jihor.example.config.ServiceProperties

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties::class)
@EnableReactiveFeignClients
class ExampleServiceApplication

fun main(args: Array<String>) {
	runApplication<ExampleServiceApplication>(*args)
}
