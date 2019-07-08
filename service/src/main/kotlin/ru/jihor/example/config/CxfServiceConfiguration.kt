package ru.jihor.example.config

import org.apache.cxf.bus.spring.SpringBus
import org.apache.cxf.interceptor.Interceptor
import org.apache.cxf.jaxws.EndpointImpl
import org.apache.cxf.message.Message
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.jihor.example.soap.ExampleServiceSoapEndpoint
import ru.jihor.example.interceptor.SoapMdcPreparingInterceptor
import javax.xml.ws.Endpoint

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@Configuration
class CxfServiceConfiguration(private val springBus: SpringBus) {

    @Bean
    fun loggingInterceptor(): SoapMdcPreparingInterceptor {
        return SoapMdcPreparingInterceptor()
    }

    @Bean
    fun endpoint(exampleServiceSoapEndpoint: ExampleServiceSoapEndpoint,
                 interceptors: List<Interceptor<out Message>>): Endpoint {
        return EndpointImpl(springBus, exampleServiceSoapEndpoint).apply {
            inInterceptors.addAll(interceptors)
            publish("/example-service")
        }
    }

}
