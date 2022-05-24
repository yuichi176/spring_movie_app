package com.example.spring_movie_app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target( {METHOD, ElementType.ANNOTATION_TYPE, FIELD, CONSTRUCTOR, PARAMETER} )
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})

@NotEmpty
@Pattern(regexp = "[a-zA-Z0-9]{4,30}")
@ReportAsSingleViolation
public @interface Password {

    /**
     * message
     */
    String message() default "パスワードに設定できる文字は4文字以上30文字以下の英数字です。";

    /**
     * groups
     */
    Class<?>[] groups() default {};

    /**
     * payload
     */
    Class<? extends Payload>[] payload() default {};

}
