package com.example.tokyorestauranttakeout.client.validators;

import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class IsExistsEmailValidator implements ConstraintValidator<IsExistsEmail, String> {

    @Autowired
    ClientAccountRepository clientAccountRepository;

    @Override
    public void initialize(IsExistsEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(!StringUtils.isEmpty(email) && clientAccountRepository.selectByEmail(email).isPresent()) {
            return false;
        }
        return true;
    }
}
