package bzh.amzerin.openD6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/openD6/css")
public class CssController {
	@GetMapping
	public String getCss() {
		return "pages/css";
	}
}
