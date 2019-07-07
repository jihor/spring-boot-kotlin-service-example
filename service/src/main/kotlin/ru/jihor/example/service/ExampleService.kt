package ru.jihor.example.service

import org.springframework.stereotype.Service
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.util.successfulResponse
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface ExampleService{
    fun getData(request: Request): Response
}

@Service
class ExampleServiceImpl: ExampleService{
    override fun getData(request: Request): Response {
        // TODO collect 2 systems using Reactor
        return successfulResponse(request, BigDecimal.ONE, LocalDateTime.now())
    }

}