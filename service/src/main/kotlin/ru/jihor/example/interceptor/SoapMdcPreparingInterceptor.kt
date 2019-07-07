package ru.jihor.example.interceptor

import lombok.extern.slf4j.Slf4j
import org.apache.catalina.connector.RequestFacade
import org.apache.cxf.binding.soap.SoapMessage
import org.apache.cxf.binding.soap.interceptor.SoapInterceptor
import org.apache.cxf.interceptor.Fault
import org.apache.cxf.phase.AbstractPhaseInterceptor
import org.apache.cxf.phase.Phase
import org.slf4j.MDC
import ru.jihor.example.util.SOAP
import ru.jihor.example.util.TRANSPORT
import ru.jihor.example.util.fillMdcWithIpAddress

import javax.xml.namespace.QName
import java.net.URI

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@Slf4j
class SoapMdcPreparingInterceptor : AbstractPhaseInterceptor<SoapMessage>(Phase.PRE_INVOKE), SoapInterceptor {

    @Throws(Fault::class)
    override fun handleMessage(message: SoapMessage) {
        MDC.clear()
        MDC.put(TRANSPORT, SOAP)

        getRequestFacade(message)?.run {
            fillMdcWithIpAddress(remoteAddr, getHeader(XFF))
        }
    }



    private fun getRequestFacade(message: SoapMessage?): RequestFacade? {
        val value = message?.get(HTTP_REQUEST)
        return if (value is RequestFacade) value else null
    }

    override fun getRoles(): Set<URI> = emptySet()

    override fun getUnderstoodHeaders(): Set<QName>? = emptySet()

    companion object {
        private const val HTTP_REQUEST = "HTTP.REQUEST"
        private const val XFF = "X-FORWARDED-FOR"
    }

}
