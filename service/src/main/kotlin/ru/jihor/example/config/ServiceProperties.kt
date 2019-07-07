package ru.jihor.example.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@ConfigurationProperties(prefix = "service")
@Validated
class ServiceProperties {

    @NotNull
    @Min(100)
    lateinit var timeout: Integer

}