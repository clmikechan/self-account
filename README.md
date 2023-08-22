先想到甚麼加甚麼, 等到比較完整時再整理

0. commit message
* 格式 [type][scope]message
> 1. type: 目前暫定有以下幾種
>> 1. feature: 新增功能
>> 2. fix: 修改錯誤
>> 3. refactor: 非新增功能, 也非修改錯誤之程式異動
>> 4. docs: 非程式異動, 包含說明文件以及規範用文件
>> * 如果日後有報表或著是圖檔之類的, 可能會新增 type 來作為其對應的 type 類別
>> * 目前只有單人開發, 並且尚未實作規範之管理辦法, 所以只是自由心證
> 2. scope 目前沒有規範有哪些 scope, 但是要大智的說明此次 commit 影響的範圍
> 3. message 簡要說明改了甚麼
* 盡量一次 commit 只做一件事. 如果一次做了不只一件事, 分行條列做的每一件事(使用相同格式)
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
5. 日期使用 `java.time.LocalDate`