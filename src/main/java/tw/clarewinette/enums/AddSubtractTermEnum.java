package tw.clarewinette.enums;

import org.apache.commons.lang3.EnumUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddSubtractTermEnum {
	A("ADD"),S("SUBTRACT"),T("TRANSFER"),I("INITIAL");

	private final String description;

	public static void main(String[] arg) {
		AddSubtractTermEnum a = EnumUtils.getEnum(AddSubtractTermEnum.class, "A");
		AddSubtractTermEnum s = EnumUtils.getEnum(AddSubtractTermEnum.class, "S");
		AddSubtractTermEnum t = EnumUtils.getEnum(AddSubtractTermEnum.class, "T");
		AddSubtractTermEnum i = EnumUtils.getEnum(AddSubtractTermEnum.class, "I");
		System.out.println(a.name() + ":" + a.getDescription());
		System.out.println(s.name() + ":" + s.getDescription());
		System.out.println(t.name() + ":" + t.getDescription());
		System.out.println(i.name() + ":" + i.getDescription());
	}
}
