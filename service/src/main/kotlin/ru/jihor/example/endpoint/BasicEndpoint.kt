package ru.jihor.example.endpoint

import org.springframework.stereotype.Service
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.service.ExampleService
import ru.jihor.example.util.badRequestResponse
import ru.jihor.example.util.exceptionResponse
import ru.jihor.example.validation.RequestValidator

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface BasicEndpoint {
    fun <T> processRequest(request: Request,
                           normalWrapper: (response: Response) -> T,
                           badRequestWrapper: (response: Response) -> T,
                           exceptionWrapper: (response: Response) -> T): T
}

@Service
class BasicEndpointImpl(private val exampleService: ExampleService,
                        private val requestValidator: RequestValidator) : BasicEndpoint {
    override fun <T> processRequest(request: Request,
                                    normalWrapper: (response: Response) -> T,
                                    badRequestWrapper: (response: Response) -> T,
                                    exceptionWrapper: (response: Response) -> T): T {
        try {
            requestValidator.validate(request).apply {
                if (hasErrors()) return badRequestWrapper.invoke(badRequestResponse(request, this))
            }
            return normalWrapper.invoke(exampleService.getData(request))
        } catch (e: Exception) {
            return exceptionWrapper.invoke(exceptionResponse(request, e))
        }

    }

}