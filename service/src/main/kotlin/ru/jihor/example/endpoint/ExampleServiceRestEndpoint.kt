package ru.jihor.example.endpoint

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.jihor.example.model.request.Request
import ru.jihor.example.model.response.Response

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
@RestController
@RequestMapping("/get-data")
class ExampleServiceRestEndpoint(private val basicEndpoint: BasicEndpoint) {
    @PostMapping
// TODO: Add Swagger and UI
//    @ApiOperation("Get data")
    fun getData(@RequestBody request: Request): ResponseEntity<Response> {
        return basicEndpoint.processRequest(request,
                { response -> ResponseEntity.ok().body(response) },
                { response -> ResponseEntity.badRequest().body(response) },
                { response -> ResponseEntity.status(INTERNAL_SERVER_ERROR).body(response) })
    }

}