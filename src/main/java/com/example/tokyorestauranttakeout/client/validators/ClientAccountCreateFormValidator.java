package com.example.tokyorestauranttakeout.client.validators;

import com.example.tokyorestauranttakeout.client.forms.ClientAccountCreateForm;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ClientAccountCreateFormValidator implements Validator {

    @Autowired
    ClientAccountRepository clientAccountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientAccountCreateForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientAccountCreateForm form = (ClientAccountCreateForm) target;

        if (!form.password.equals(form.passwordDigest)) {
            errors.rejectValue("passwordDigest", "invalid.passwordDigest","確認パスワードが誤っています。");
        }

    }

}
