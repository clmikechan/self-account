package tw.clarewinette.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDataId implements Serializable {

	@Column(name = "user_id", nullable = false)
	private int userId;

}
