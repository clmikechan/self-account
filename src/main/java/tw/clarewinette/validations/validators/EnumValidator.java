package tw.clarewinette.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.EnumUtils;

import tw.clarewinette.validations.annotations.EnumValid;

public class EnumValidator implements ConstraintValidator<EnumValid, String>{
	private EnumValid enumValid;

	@Override
    public void initialize(EnumValid enumValid) {
		ConstraintValidator.super.initialize(enumValid);
		this.enumValid = enumValid;

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Class<? extends Enum> useEnum = enumValid.useEnum();
		return EnumUtils.getEnum(useEnum, value) != null;

	}

}
