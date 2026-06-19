package bzh.amzerin.openD6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/openD6/attributes")
public class AttributeController {

	@GetMapping
	public String getAttributes() {
		return "pages/attribute";
	}
	
}
