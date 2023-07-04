package tw.clarewinette.models.entities.transactions;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.clarewinette.models.entities.UserDataId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDataId implements Serializable {
	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;

	@Column(name = "transaction_seqno", nullable = false)
	private int transactionSeqno;
}
