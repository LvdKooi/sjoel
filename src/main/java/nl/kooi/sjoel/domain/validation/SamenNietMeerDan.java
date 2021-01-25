package nl.kooi.sjoel.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {SamenNietMeerDanValidator.class}
)
public @interface SamenNietMeerDan {
    String message() default "'{velden}' mogen samen niet meer dan {max} zijn.";

    int max();

    String[] velden();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
