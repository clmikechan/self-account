package tw.clarewinette.models.entities.transactions;

import java.io.Serializable;
import java.util.Date;
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
public class TransactionDataId implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int HASHCODE_INIT = EntitiesConstant.HASHCODE_INIT;

	private static final int HASHCODE_PRIME = EntitiesConstant.HASHCODE_PRIME;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;

	@Column(name = "transaction_seqno", nullable = false)
	private int transactionSeqno;

	@Override
	public int hashCode() {
		int hashCode = HASHCODE_INIT;
		hashCode = hashCode * HASHCODE_PRIME + transactionSeqno;
		hashCode = hashCode * HASHCODE_PRIME + transactionDate.hashCode();
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
		TransactionDataId other = (TransactionDataId) obj;
		return Objects.equals(this.getTransactionSeqno(), other.getTransactionSeqno()) && Objects.equals(this.getTransactionDate(), other.getTransactionDate()) && Objects.equals(this.getUserId(), other.getUserId());
	}

}
