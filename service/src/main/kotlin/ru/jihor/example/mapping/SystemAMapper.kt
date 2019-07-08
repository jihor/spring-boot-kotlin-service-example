package ru.jihor.example.mapping

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.jihor.example.model.request.RequestBusinessData
import ru.jihor.example.model.response.ResponseBusinessData

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
@Mapper
interface SystemAMapper {

    @Mapping(expression = "java(ru.jihor.example.mapping.MappingUtilsKt.birthDateToAge(requestBusinessData.getBirthDate()))", target = "age")
    fun convertToSystemARequest(requestBusinessData: RequestBusinessData): com.system_a.fico_scoring.Request

    @InheritInverseConfiguration
    @Mapping(source = "score", target = "ficoScore")
    fun convertFromSystemAResponse(response: com.system_a.fico_scoring.Response): ResponseBusinessData

}