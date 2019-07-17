package ru.jihor.example.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 18.07.2019
 */
@Component
@Aspect
class BusinessLoggingAspect {

    @Around("execution(* ru.jihor.example.service.ExampleService.getData(..))")
    fun aroundBusinessOperation(proceedingJoinPoint: ProceedingJoinPoint): Any {
        proceedingJoinPoint.let {
            log.info(STARTED)
            try {
                val result = proceedingJoinPoint.proceed()
                log.info(COMPLETED)
                return result
            } catch (t: Throwable) {
                log.info(FAILED)
                throw t
            }
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger("businessOperationLogger")
        private const val STARTED = "Started"
        private const val COMPLETED = "Completed"
        private const val FAILED = "Failed"
    }

}