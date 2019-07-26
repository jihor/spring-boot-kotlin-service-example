package ru.jihor.example.util

import org.springframework.validation.ObjectError
import ru.jihor.example.ResponseCodes.*
import ru.jihor.example.model.Request
import ru.jihor.example.model.Response
import ru.jihor.example.model.ResponseBusinessData
import ru.jihor.example.model.ResponseTechData
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

fun successfulResponse(request: Request?, data: ResponseBusinessData): Response {
    return Response().apply {
        techData = ResponseTechData().apply {
            correlationId = request?.techData?.correlationId
            responseCode = OK
        }
        businessData = data
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

fun notAllowedResponse(request: Request?): Response {
    return Response().apply {
        techData = ResponseTechData().apply {
            correlationId = request?.techData?.correlationId
            responseCode = NOT_ALLOWED
            errorDescription = "Request blocked by business rules"
        }
    }
}