package com.system_b.fico;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 09.07.2019
 */
@Data
@NoArgsConstructor
public class FicoResponse {
    private double value;
    private LocalDateTime updatedAt;
}
