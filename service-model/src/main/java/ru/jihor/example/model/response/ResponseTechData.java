package ru.jihor.example.model.response;

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
@ApiModel(description = "Response tech data block")
public class ResponseTechData {

    @ApiModelProperty(required = true)
    private String correlationId;

    @ApiModelProperty(required = true)
    private String responseCode;

    private String errorDescription;

}
