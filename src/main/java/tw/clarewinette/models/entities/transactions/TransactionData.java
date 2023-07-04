package tw.clarewinette.models.entities.transactions;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transaction_data")
public class TransactionData implements Serializable {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
		@AttributeOverride(name = "transactionDate", column = @Column(name = "transaction_date", nullable = false)),
		@AttributeOverride(name = "transactionSeqno", column = @Column(name = "transaction_seqno", nullable = false)) })
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
}
