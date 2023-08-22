package tw.clarewinette.models.entities.lists;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.clarewinette.constants.EntitiesConstant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class DetailsTypeId implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int HASHCODE_INIT = EntitiesConstant.HASHCODE_INIT;

	private static final int HASHCODE_PRIME = EntitiesConstant.HASHCODE_PRIME;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "details_type_no", nullable = false)
	private int detailsTypeNo;

	@Override
	public int hashCode() {
		int hashCode = HASHCODE_INIT;
		hashCode = hashCode * HASHCODE_PRIME + detailsTypeNo;
		hashCode = hashCode * HASHCODE_PRIME + userId;
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsTypeId other = (DetailsTypeId) obj;
		return Objects.equals(this.getDetailsTypeNo(), other.getDetailsTypeNo()) && Objects.equals(this.getUserId(), other.getUserId());
	}
}
