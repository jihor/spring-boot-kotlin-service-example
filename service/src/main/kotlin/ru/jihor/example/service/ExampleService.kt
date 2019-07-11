package ru.jihor.example.service

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.jihor.example.feign.SystemBFeignClient
import ru.jihor.example.mapping.SystemAMapper
import ru.jihor.example.mapping.SystemBMapper
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.model.response.ResponseBusinessData
import ru.jihor.example.util.successfulResponse

typealias SystemAService = com.system_a.fico_scoring.FicoService
typealias SystemBService = SystemBFeignClient

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface ExampleService {
    fun getData(request: Request): Response
}

@Service
class ExampleServiceImpl(private val systemAService: SystemAService,
                         private val systemBService: SystemBService) : ExampleService {
    val systemAMapper = Mappers.getMapper(SystemAMapper::class.java)
    val systemBMapper = Mappers.getMapper(SystemBMapper::class.java)

    override fun getData(request: Request): Response {
        return Mono.zip(getSystemAResponseMono(request), getSystemBResponseMono(request)) { a, b -> if (a.ficoScore > b.ficoScore) a else b }
                .map { successfulResponse(request, it) }
                .block()!!
    }

    private fun getSystemBResponseMono(request: Request): Mono<ResponseBusinessData> {
        return Mono.just(request.businessData)
                .map(systemBMapper::convertToSystemBRequest)
                .flatMap(systemBService::getScore)
                .map(systemBMapper::convertFromSystemBResponse)
    }

    private fun getSystemAResponseMono(request: Request): Mono<ResponseBusinessData> {
        return Mono.create { sink ->
            systemAService.getScoreAsync(systemAMapper.convertToSystemARequest(request.businessData)) { response ->
                sink.success(systemAMapper.convertFromSystemAResponse(response.get()))
            }
        }
    }

}