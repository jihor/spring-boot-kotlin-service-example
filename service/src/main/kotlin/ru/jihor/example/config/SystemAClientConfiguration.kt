package ru.jihor.example.config

import com.system_a.fico_scoring.FicoService
import com.system_a.fico_scoring.FicoService_Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.BindingProvider
import javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
@Configuration
class SystemAClientConfiguration {
    @Autowired
    lateinit var serviceProperties: ServiceProperties

    @Bean
    fun systemAClient(): FicoService {
        return FicoService_Service().ficoServicePort.also {
            val bindingProvider = it as BindingProvider
            bindingProvider.requestContext[ENDPOINT_ADDRESS_PROPERTY] = serviceProperties.systemAEndpoint
        }
    }
}