package com.system_b.fico;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 09.07.2019
 */
public interface FicoService {
    @PostMapping("/score")
    FicoResponse getScore(@RequestBody FicoRequest request);
}
