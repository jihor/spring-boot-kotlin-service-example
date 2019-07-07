package ru.jihor.example.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
@Data
@NoArgsConstructor
@ApiModel(description = "Response business data block")
public class ResponseBusinessData {

    @ApiModelProperty("Person's FICO score")
    private BigDecimal ficoScore;

    @ApiModelProperty("Last update date/time")
    private LocalDateTime lastUpdated;

    @ApiModelProperty("Some cynical comments")
    private List<String> footnotes;
}
