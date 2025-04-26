package com.academai.academai.validation.impl;

import com.academai.academai.service.UserService;
import com.academai.academai.validation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && !userService.checkIfUserExistsByEmail(email);
    }
}
