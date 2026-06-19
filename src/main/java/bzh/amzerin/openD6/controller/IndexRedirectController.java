package bzh.amzerin.openD6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexRedirectController {

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/openD6";
    }
}
