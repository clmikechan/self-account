先想到甚麼加甚麼, 等到比較完整時再整理

1. 命名規範
> 1. **project-name**: 全小寫, 用`-`連接.
> 2. **packagename**: 全小寫.
> 3. **ClassName**: 首字大寫駝峰型.

2. 至少要有 `SpringBootApplication`, `SpringBootServletInitializer` 才能執行.

3. *Validation Annotation*: 需要一個 `ValidAnnotation` 以及一個 `Validator`
```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = Validator.class)
@Retention(RetentionPolicy)
public @interface ValidationAnnotation {
	String message() default "檢核錯誤時的訊息";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
```

```java
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<ValidationAnnotation, T> {
	@Override
	public void initialize(ValidationAnnotation validationAnnotation) {
	}

	@Override
	boolean isValid(T value, ConstraintValidatorContext context) {
	}
}
```

4. 控管: 每一個 table 之 PK 都要包含 int user_id 欄位. 每一個資料庫存取的地方都要有附加 `where user_id=?` 之條件.(取得 user_id 之方法待確認.)
