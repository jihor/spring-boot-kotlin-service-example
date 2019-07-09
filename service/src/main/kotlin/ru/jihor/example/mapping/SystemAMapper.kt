package ru.jihor.example.mapping

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.jihor.example.model.request.RequestBusinessData
import ru.jihor.example.model.response.ResponseBusinessData

typealias SystemARequest = com.system_a.fico_scoring.Request
typealias SystemAResponse= com.system_a.fico_scoring.Response
/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
@Mapper
interface SystemAMapper {

    @Mapping(expression = "java(ru.jihor.example.mapping.MappingUtilsKt.birthDateToAge(requestBusinessData.getBirthDate()))", target = "age")
    fun convertToSystemARequest(requestBusinessData: RequestBusinessData): SystemARequest

    @Mapping(source = "score", target = "ficoScore")
    fun convertFromSystemAResponse(response: SystemAResponse): ResponseBusinessData

}