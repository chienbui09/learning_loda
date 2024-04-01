package com.personal.data;

import com.personal.annotation.ValidEmployeeCode;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Info {
    @ValidEmployeeCode
    @NotBlank
    private String employee;
}
