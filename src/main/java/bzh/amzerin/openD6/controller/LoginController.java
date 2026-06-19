package bzh.amzerin.openD6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
	@GetMapping("/openD6/login")
	String login() {
		return "pages/login";
	}
}