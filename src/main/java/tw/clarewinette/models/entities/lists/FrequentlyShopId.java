package tw.clarewinette.models.entities.lists;

import java.io.Serializable;

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
public class FrequentlyShopId implements Serializable {
	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "frequently_shop_no", nullable = false)
	private int frequentlyShopNo;

}
