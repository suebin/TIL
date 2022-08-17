package nonspringmvc;

import java.util.HashMap;

// Controller를 찾는다.
public class HandlerMapping {
	// 생성자
	HashMap<String, Controller> mappings = new HashMap<String, Controller>();

	HandlerMapping() {		
		mappings.put("hello", new HelloController()); // http://localhost:8080/nonspringmvc/hello
		mappings.put("list", new ListController());
	}
	
	Controller getController(String key) {
		return mappings.get(key);
	}
}
