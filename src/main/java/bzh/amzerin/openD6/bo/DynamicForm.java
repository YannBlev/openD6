package bzh.amzerin.openD6.bo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class DynamicForm {
	private Map<String, Object> fields = new HashMap<>();
	
}
