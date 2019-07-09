package ru.jihor.example.mocks.config

import com.system_a.fico_scoring.FicoService
import org.apache.cxf.bus.spring.SpringBus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@Configuration
class SystemAMockConfiguration(private val springBus: SpringBus) {

    @Bean
    fun endpoint(ficoService: FicoService): Endpoint {
        return EndpointImpl(springBus, ficoService).apply {
            publish("/system-a")
        }
    }

}
