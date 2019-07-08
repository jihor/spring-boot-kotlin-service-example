package ru.jihor.example.mocks.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@Configuration
class ObjectMappingConfiguration {
    @Bean
    fun objectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper {
        return builder.build<ObjectMapper>().apply {
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }
}