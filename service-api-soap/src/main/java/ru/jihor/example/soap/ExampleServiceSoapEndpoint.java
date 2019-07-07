package ru.jihor.example.soap;

import ru.jihor.example.model.request.Request;
import ru.jihor.example.model.response.Response;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
@WebService(targetNamespace = "http://jihor.ru/example-service/v1/types", name = "ExampleService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ExampleServiceSoapEndpoint {
        @WebResult(name = "getDataResponse", targetNamespace = "http://jihor.ru/example-service/v1/types/response")
        Response getData(@WebParam(name = "getDataRequest", targetNamespace = "http://jihor.ru/example-service/v1/types/request") Request request);
}
