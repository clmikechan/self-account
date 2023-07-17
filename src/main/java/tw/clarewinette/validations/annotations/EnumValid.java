package tw.clarewinette.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tw.clarewinette.validations.validators.EnumValidator;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValid {
	String message() default "Invalid value";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

	Class<? extends Enum> useEnum();

}
