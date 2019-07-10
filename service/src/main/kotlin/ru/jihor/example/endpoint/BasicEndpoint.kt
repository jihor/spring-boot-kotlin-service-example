package ru.jihor.example.endpoint

import org.springframework.stereotype.Service
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.service.ExampleService
import ru.jihor.example.util.badRequestResponse
import ru.jihor.example.util.exceptionResponse
import ru.jihor.example.util.notAllowedResponse
import ru.jihor.example.validation.RequestValidator
import ru.jihor.spelgates.SpelGate

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface BasicEndpoint {
    fun <T> processRequest(request: Request,
                           spelGate: SpelGate<Boolean>,
                           normalWrapper: (response: Response) -> T,
                           notAllowedWrapper: (response: Response) -> T,
                           badRequestWrapper: (response: Response) -> T,
                           exceptionWrapper: (response: Response) -> T): T
}

@Service
class BasicEndpointImpl(private val exampleService: ExampleService,
                        private val requestValidator: RequestValidator) : BasicEndpoint {
    override fun <T> processRequest(request: Request,
                                    spelGate: SpelGate<Boolean>,
                                    normalWrapper: (response: Response) -> T,
                                    notAllowedWrapper: (response: Response) -> T,
                                    badRequestWrapper: (response: Response) -> T,
                                    exceptionWrapper: (response: Response) -> T): T {
        try {
            requestValidator.validate(request).let {
                if (it.hasErrors()) return badRequestWrapper.invoke(badRequestResponse(request, it))
            }
            spelGate.evaluate(this, "request", request).let { allowed ->
                if (allowed == false) return notAllowedWrapper(notAllowedResponse(request))
            }
            return normalWrapper.invoke(exampleService.getData(request))
        } catch (e: Exception) {
            return exceptionWrapper.invoke(exceptionResponse(request, e))
        }

    }

}