package ru.jihor.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.jihor.example.config.ServiceProperties

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties::class)
class ExampleServiceApplication

fun main(args: Array<String>) {
	runApplication<ExampleServiceApplication>(*args)
}
