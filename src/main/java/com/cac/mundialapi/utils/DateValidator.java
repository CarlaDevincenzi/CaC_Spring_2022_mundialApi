package com.cac.mundialapi.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<BeforeDate, LocalDate> {

    private String validDate;

    @Override
    public void initialize(BeforeDate constraintAnnotation) {
        this.validDate = constraintAnnotation.current();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        String[] splitDate = validDate.split("-");
        return localDate.isBefore(LocalDate.of(Integer.valueOf(splitDate[0]),
                Integer.valueOf(splitDate[1]), Integer.valueOf(splitDate[2])));
    }
}
