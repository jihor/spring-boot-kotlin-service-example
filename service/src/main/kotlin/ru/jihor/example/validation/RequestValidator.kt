package ru.jihor.example.validation

import org.springframework.stereotype.Service
import ru.jihor.example.ResponseCodes.VALIDATION_FAILED
import ru.jihor.example.model.Request

@Service
class RequestValidator {
    fun validate(request: Request): CodedErrors {
        val errors = getCodedErrors()
        try {
            doValidate(request, errors,
                    this::validateRequest,
                    this::validateTechData,
                    this::validateBusinessData)
        } catch (e: Exception) {
            // TODO: log
            errors.reject(VALIDATION_FAILED, "further validations failed")
        }
        return errors
    }

    private fun doValidate(request: Request, errors: CodedErrors, vararg validations: (Request?, CodedErrors) -> Unit): CodedErrors {
        validations.asSequence()
                .forEach { v -> v.invoke(request, errors) }
        return errors
    }

    private fun validateRequest(request: Request?, errors: CodedErrors) {
        if (request == null) errors.reject(VALIDATION_FAILED, "request is empty")
    }

    private fun validateTechData(request: Request?, errors: CodedErrors) {
        if (request!!.techData == null) errors.reject(VALIDATION_FAILED, "techData block is missing")
    }

    private fun validateBusinessData(request: Request?, errors: CodedErrors) {
        if (request!!.businessData == null) errors.reject(VALIDATION_FAILED, "businessData block is missing")
    }

}
