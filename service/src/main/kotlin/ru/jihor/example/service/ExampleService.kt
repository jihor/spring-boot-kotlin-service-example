package ru.jihor.example.service

import com.system_a.fico_scoring.FicoService
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import ru.jihor.example.mapping.SystemAMapper
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.util.successfulResponse

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface ExampleService{
    fun getData(request: Request): Response
}

@Service
class ExampleServiceImpl(private val ficoService: FicoService): ExampleService{
    val mapper = Mappers.getMapper(SystemAMapper::class.java)

    override fun getData(request: Request): Response {
        // TODO collect 2 systems using Reactor
        val systemARequest = mapper.convertToSystemARequest(request.businessData)
        val systemAResponse = ficoService.getScore(systemARequest)
        val responseBusinessData = mapper.convertFromSystemAResponse(systemAResponse)
        return successfulResponse(request, responseBusinessData)
//        return successfulResponse(request, BigDecimal.ONE, LocalDateTime.now())
    }

}