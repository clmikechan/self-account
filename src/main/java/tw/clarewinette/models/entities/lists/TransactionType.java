package tw.clarewinette.models.entities.lists;

import java.io.Serializable;

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
@Table(name = "transaction_type")
public class TransactionType implements Serializable {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "transactionTypeNo", column = @Column(name = "transaction_type_no", nullable = false)) })
	private TransactionTypeId id;

	@Column(name = "transaction_type_name", nullable = false)
	private String transactionTypeName;
}
