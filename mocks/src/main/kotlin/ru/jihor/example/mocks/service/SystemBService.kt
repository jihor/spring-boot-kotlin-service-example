package ru.jihor.example.mocks.service

import com.system_b.fico.FicoRequest
import com.system_b.fico.FicoResponse
import com.system_b.fico.FicoService
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
@RestController
class SystemBService : FicoService {
    override fun getScore(request: FicoRequest?): FicoResponse {
        return FicoResponse().apply {
            value = 560.0
            updatedAt = LocalDateTime.now().minusDays(1)
        }
    }
}