package edu.joseph.crudclient.model.ageverification;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AgeRestrictionValidator implements ConstraintValidator<AgeRestriction, LocalDate> {

    @Override
    public void initialize(AgeRestriction constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return true;
        }
        LocalDate now = LocalDate.now();
        LocalDate ofLegalAge = now.minusYears(18);
        return birthDate.isBefore(ofLegalAge);
    }
}
