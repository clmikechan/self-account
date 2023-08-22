package tw.clarewinette.models.entities.transactions;

import java.util.Date;
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
@Table(name = "transaction_data")
public class TransactionData {
	@EmbeddedId
	private TransactionDataId id;

	@Column(name = "frequently_shop_no")
	private int frequentlyShopNo;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "transaction_type_no")
	private int transactionTypeNo;

	@Column(name = "transaction_name", nullable = false)
	private String transactionName;

	@Column(name = "outgoing_account_no")
	private int outgoingAccountNo;

	@Column(name = "outgoing_account_state")
	private boolean outgoingAccountState;

	@Column(name = "outgoing_accounted_date")
	private Date outgoingAccountedDate;

	@Column(name = "incoming_account_no")
	private int incomingAccountNo;

	@Column(name = "incoming_account_state")
	private boolean incomingAccountState;

	@Column(name = "incoming_accounted_date")
	private Date incomingAccountedDate;

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
		TransactionData other = (TransactionData) obj;
		return Objects.equals(this.getId(), other.getId());
	}

	/**
	 * 使用者代號等於
	 *
	 * @param userId 使用者代號
	 * @return 使用者代號等於 spec
	 */
	public static Specification<TransactionData> userIdEqual(int userId) {
		return (root, query, builder) -> builder.equal(root.get("id").get("userId"), userId);
	}

}
