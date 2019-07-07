package ru.jihor.example.util

import org.springframework.validation.ObjectError
import ru.jihor.example.ResponseCodes.*
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response
import ru.jihor.example.model.response.ResponseBusinessData
import ru.jihor.example.model.response.ResponseTechData
import ru.jihor.example.validation.CodedErrors
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
private const val SEMICOLON = ";"

fun badRequestResponse(request: Request?, codedErrors: CodedErrors): Response {
    return Response().apply {
        techData = ResponseTechData().apply {
            correlationId = request?.techData?.correlationId
            responseCode = VALIDATION_FAILED
            errorDescription = codedErrors.errors.allErrors.asSequence()
                    .filter { it.defaultMessage != null }
                    .joinToString(separator = SEMICOLON, transform = ObjectError::getDefaultMessage)
        }
    }
}

fun successfulResponse(request: Request?, ficoScore: BigDecimal, lastUpdated: LocalDateTime): Response {
    return Response().apply {
        techData = ResponseTechData().apply {
            correlationId = request?.techData?.correlationId
            responseCode = OK
        }
        businessData = ResponseBusinessData().apply {
            this.ficoScore = ficoScore
            this.lastUpdated = lastUpdated
        }
    }
}

fun exceptionResponse(request: Request?, e: Exception): Response {
    return Response().apply {
        techData = ResponseTechData().apply {
            correlationId = request?.techData?.correlationId
            responseCode = SYSTEM_EXCEPTION
            errorDescription = "Internal error"
        }
    }
}