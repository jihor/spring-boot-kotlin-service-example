package ru.jihor.example.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
@Data
@NoArgsConstructor
@ApiModel(description = "Request business data block")
public class RequestBusinessData {

    @ApiModelProperty(value = "Person's first name", required = true)
    private String firstName;

    @ApiModelProperty(value = "Person's last name", required = true)
    private String lastName;

    @ApiModelProperty("Person's birth date")
    private LocalDate birthDate;

    @ApiModelProperty("Person's gender")
    private Gender gender;

}
