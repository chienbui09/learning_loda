package com.personal.validation;

import com.personal.annotation.ValidEmployeeCode;
import com.personal.common.Regexes;
import com.personal.exception.NodataException;
import com.personal.exception.PermissionException;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployCodeValidator implements ConstraintValidator<ValidEmployeeCode, String> {
    @Override
    public void initialize(ValidEmployeeCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.hasText(s)){
            return false;
        }

        if (s.matches(Regexes.VALID_EMPLOYEE_REGEX)){
            return true;
        }
        if (s.matches(Regexes.INVALID_EMPLOYEE_REGEX)){
            switch (s){
                case "E00":{
                    throw new PermissionException();
                } case "E01": {
                    throw new NodataException();
                } default:{
                    throw new RuntimeException();
                }
            }
        }
        return false;
    }
}
