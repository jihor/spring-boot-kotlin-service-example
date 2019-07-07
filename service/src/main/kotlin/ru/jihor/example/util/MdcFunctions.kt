package ru.jihor.example.util

import com.google.common.net.HttpHeaders
import org.apache.commons.lang3.StringUtils
import org.slf4j.MDC
import java.util.*

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
fun fillMdcWithIpAddress(remoteAddr: String?, forwardedFor: String?) {
    val sj = StringJoiner("; ")

    if (!StringUtils.isEmpty(remoteAddr)) {
        sj.add("Remote host: $remoteAddr")
    }

    if (!StringUtils.isEmpty(forwardedFor)) {
        sj.add(HttpHeaders.X_FORWARDED_FOR + ": " + forwardedFor)
    }

    if (sj.length() > 0) {
        MDC.put(IP_ADDRESS, sj.toString())
    }
}