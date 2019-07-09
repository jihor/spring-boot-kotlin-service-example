package ru.jihor.example.feign

import com.system_b.fico.FicoRequest
import com.system_b.fico.FicoResponse
import feign.Headers
import org.springframework.web.bind.annotation.PostMapping
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 *         TODO: Consider replacing all this w/coroutines
 */
// can't extend com.system_b.fico.FicoService because we need a reactive interface, and annotations are also different
@ReactiveFeignClient(name = "system-b-service", url = "\${service.systemBUrl:http://system-b-service}")
@Headers("Accept: application/json")
interface SystemBFeignClient {
    @PostMapping("/score")
    @Headers("Content-Type: application/json")
    fun getScore(request: FicoRequest): Mono<FicoResponse>
}