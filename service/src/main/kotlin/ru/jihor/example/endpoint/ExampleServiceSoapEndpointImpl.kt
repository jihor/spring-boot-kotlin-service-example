package ru.jihor.example.endpoint

import org.springframework.stereotype.Service
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.soap.ExampleServiceSoapEndpoint
import javax.jws.WebService

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@Service
@WebService(targetNamespace = "http://jihor.ru/example-service/v1/types", name = "ExampleService")
class ExampleServiceSoapEndpointImpl(private val basicEndpoint: BasicEndpoint) : ExampleServiceSoapEndpoint {
    override fun getData(request: Request): Response {
        return basicEndpoint.processRequest(request,
                this::identity,
                this::identity,
                this::identity)
    }

    fun <T> identity(x: T): T = x
}