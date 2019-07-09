package ru.jihor.example.mapping

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import ru.jihor.example.model.request.RequestBusinessData
import ru.jihor.example.model.response.ResponseBusinessData

typealias SystemBRequest = com.system_b.fico.FicoRequest
typealias SystemBResponse = com.system_b.fico.FicoResponse

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
@Mapper
interface SystemBMapper {

    fun convertToSystemBRequest(requestBusinessData: RequestBusinessData): SystemBRequest

    @Mappings(
            Mapping(source = "value", target = "ficoScore"),
            Mapping(source = "updatedAt", target = "lastUpdated")
    )
    fun convertFromSystemBResponse(response: SystemBResponse): ResponseBusinessData

}