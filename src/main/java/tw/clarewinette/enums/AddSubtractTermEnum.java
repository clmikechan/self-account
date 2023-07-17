package tw.clarewinette.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddSubtractTermEnum {
	A("ADD"),
	S("SUBTRACT"),
	T("TRANSFER"),
	I("INITIAL");

	private final String description;

}
