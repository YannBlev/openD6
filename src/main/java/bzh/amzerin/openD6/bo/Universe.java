package bzh.amzerin.openD6.bo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Universe {

	private int id;
	private String name;
	List<Attribute> attributes;
}
