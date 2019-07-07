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
@ApiModel(description = "Response block")
public class Response {

    @ApiModelProperty(required = true)
    private ResponseTechData techData;

    private ResponseBusinessData businessData;
}

