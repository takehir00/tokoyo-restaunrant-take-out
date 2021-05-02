package com.example.tokyorestauranttakeout.client.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IsExistsEmailValidator.class)
public @interface IsExistsEmail {
    String message() default "既に存在するメールアドレスです。";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
