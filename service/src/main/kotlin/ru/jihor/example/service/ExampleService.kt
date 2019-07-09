package ru.jihor.example.service

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import ru.jihor.example.feign.SystemBFeignClient
import ru.jihor.example.mapping.SystemAMapper
import ru.jihor.example.mapping.SystemBMapper
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
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
        // TODO collect 2 systems using Reactor, write a facade over this map-invoke-map logic
        val systemARequest = systemAMapper.convertToSystemARequest(request.businessData)
        val systemAResponse = systemAService.getScore(systemARequest)
        val responseBusinessDataA = systemAMapper.convertFromSystemAResponse(systemAResponse)

        val systemBRequest = systemBMapper.convertToSystemBRequest(request.businessData)
        val systemBResponse = systemBService.getScore(systemBRequest).block()!!
        val responseBusinessDataB = systemBMapper.convertFromSystemBResponse(systemBResponse)

        val data = if (responseBusinessDataA.ficoScore > responseBusinessDataB.ficoScore) responseBusinessDataA else responseBusinessDataB
        return successfulResponse(request, data)
//        return successfulResponse(request, BigDecimal.ONE, LocalDateTime.now())
    }

}