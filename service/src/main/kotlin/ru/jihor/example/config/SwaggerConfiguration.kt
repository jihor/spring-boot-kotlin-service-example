package ru.jihor.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 08.07.2019
 */
@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2) // look for Swagger2 annotations
            .select()
            .paths(PathSelectors.ant("/get-data"))
            .build()
}