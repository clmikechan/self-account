package tw.clarewinette.models.apis.list;

import javax.validation.constraints.NotNull;

import lombok.Data;
import tw.clarewinette.enums.AddSubtractTermEnum;
import tw.clarewinette.validations.annotations.EnumValid;

@Data
public class DetailsTypeRequest {
	@NotNull
	private String detailsTypeName;

	@EnumValid(useEnum=AddSubtractTermEnum.class)
	private String addSubtractTerm;

}
