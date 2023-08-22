package tw.clarewinette.models.entities.lists;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "account_data")
public class AccountData {

	@EmbeddedId
	private AccountDataId id;

	@Column(name = "account_name", nullable = false, length = 255)
	private String accountName;

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountData other = (AccountData) obj;
		return Objects.equals(this.getId(), other.getId());
	}

	/**
	 * 使用者代號等於
	 *
	 * @param userId 使用者代號
	 * @return 使用者代號等於 spec
	 */
	public static Specification<AccountData> userIdEqual(int userId) {
		return (root, query, builder) -> builder.equal(root.get("id").get("userId"), userId);
	}
}
