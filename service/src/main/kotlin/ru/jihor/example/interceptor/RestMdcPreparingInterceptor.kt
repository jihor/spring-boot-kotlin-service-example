package ru.jihor.example.interceptor

import org.slf4j.MDC
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import ru.jihor.example.util.REST
import ru.jihor.example.util.TRANSPORT
import ru.jihor.example.util.fillMdcWithIpAddress
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RestMdcPreparingInterceptor: HandlerInterceptorAdapter() {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        MDC.clear()
        MDC.put(TRANSPORT, REST)
        fillMdcWithIpAddress(request.remoteAddr, request.getHeader(XFF))
        return true
    }

    companion object {
        private const val XFF = "X-FORWARDED-FOR"
    }

}