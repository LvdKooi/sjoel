package nl.kooi.sjoel.domain.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class SamenNietMeerDanValidator implements ConstraintValidator<SamenNietMeerDan, Object> {
    private String[] velden;
    private int max;

    public void initialize(SamenNietMeerDan constraintAnnotation) {
        this.velden = constraintAnnotation.velden();
        this.max = constraintAnnotation.max();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(value);
        String[] var4 = this.velden;
        int var5 = var4.length;
        int total = 0;

        for (int var6 = 0; var6 < var5; ++var6) {
            String veld = var4[var6];
            total += Integer.parseInt(Objects.requireNonNull(wrapper.getPropertyValue(veld)).toString());
        }

        if (total <= max) {

            return true;
        }

        return false;
    }
}
