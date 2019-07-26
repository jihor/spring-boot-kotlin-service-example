package ru.jihor.example.mapping

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.jihor.example.model.RequestBusinessData
import ru.jihor.example.model.ResponseBusinessData

typealias SystemARequest = com.system_a.fico_scoring.FicoRequestType
typealias SystemAResponse= com.system_a.fico_scoring.FicoResponseType
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