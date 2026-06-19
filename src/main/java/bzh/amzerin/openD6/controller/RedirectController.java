package bzh.amzerin.openD6.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping(value = "/openD6/{path:[^\\.]*}")
    public String redirect() {
        return "redirect:/openD6";
    }
}