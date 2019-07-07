package ru.jihor.example.validation

import org.springframework.validation.Errors
import org.springframework.validation.MapBindingResult

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
private const val ERRORS_OBJECT = "errors"

fun getCodedErrors(): CodedErrors {
    val errors = MapBindingResult(mutableMapOf<String, String>(), ERRORS_OBJECT)
    return CodedErrors(errors)
}

data class CodedErrors(val errors: Errors, var responseCode: String? = null) {

    fun reject(errorCode: String, defaultMessage: String) {
        errors.reject(errorCode, defaultMessage)
        responseCode = errorCode
    }

    fun hasErrors() = errors.hasErrors()
}
