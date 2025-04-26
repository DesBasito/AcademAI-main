package com.academai.academai.validation.impl;

import com.academai.academai.dto.user.RegistrationRequest;
import com.academai.academai.validation.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegistrationRequest> {

    @Override
    public boolean isValid(RegistrationRequest request, ConstraintValidatorContext context) {
        if (request.getPassword() == null || request.getConfirmPassword() == null) {
            return true;
        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Пароли не совпадают!")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
