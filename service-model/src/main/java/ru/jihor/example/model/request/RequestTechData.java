package ru.jihor.example.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
@Data
@NoArgsConstructor
@ApiModel(description = "Request tech data block")
public class RequestTechData {

    @ApiModelProperty(required = true)
    private String correlationId;

}
