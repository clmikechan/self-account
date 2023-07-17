package tw.clarewinette.models.entities.transactions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "details")
public class Details implements Serializable {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
		@AttributeOverride(name = "transactionDate", column = @Column(name = "transaction_date", nullable = false)),
		@AttributeOverride(name = "transactionSeqno", column = @Column(name = "transaction_seqno", nullable = false)),
		@AttributeOverride(name = "detailsSeqno", column = @Column(name = "details_seqno", nullable = false)) })
	private DetailsId id;

	@Column(name = "details_Name")
	private String detailsName;

	@Column(name = "details_type_no")
	private int detailsTypeNo;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "rate")
	private BigDecimal rate;

	/**
	 * 使用者代號等於
	 *
	 * @param userId 使用者代號
	 * @return 使用者代號等於 spec
	 */
	public static Specification<Details> userIdEqual(int userId) {
		return (root, query, builder) -> builder.equal(root.get("id").get("userId"), userId);
	}

}
