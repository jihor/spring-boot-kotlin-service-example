package ru.jihor.example.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import ru.jihor.example.interceptor.RestMdcPreparingInterceptor

@Configuration
class InterceptorsConfiguration : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(RestMdcPreparingInterceptor())
                .addPathPatterns("/get-data")
    }

}