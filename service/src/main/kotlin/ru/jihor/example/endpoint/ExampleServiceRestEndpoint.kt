package ru.jihor.example.endpoint

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.I_AM_A_TEAPOT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.jihor.example.model.Request
import ru.jihor.example.model.Response
import ru.jihor.spelgates.SpelGate

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@RestController
@RequestMapping("/get-data")
class ExampleServiceRestEndpoint(private val basicEndpoint: BasicEndpoint,
                                 private val restEndpointGate: SpelGate<Boolean>) {
    @PostMapping
// TODO: Add Swagger and UI
//    @ApiOperation("Get data")
    fun getData(@RequestBody request: Request): ResponseEntity<Response> {
        return basicEndpoint.processRequest(request,
                restEndpointGate,
                { response -> ResponseEntity.ok().body(response) },
                { response -> ResponseEntity.status(I_AM_A_TEAPOT).body(response) },
                { response -> ResponseEntity.badRequest().body(response) },
                { response -> ResponseEntity.status(INTERNAL_SERVER_ERROR).body(response) })
    }

}