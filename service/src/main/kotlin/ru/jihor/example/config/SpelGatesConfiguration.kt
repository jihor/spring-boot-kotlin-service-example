package ru.jihor.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.jihor.spelgates.SpelGate

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 10.07.2019
 */
@Configuration
class SpelGatesConfiguration {
    @Bean
    fun soapEndpointGate(): SpelGate<Boolean> = SpelGate()

    @Bean
    fun restEndpointGate(): SpelGate<Boolean> = SpelGate()
}