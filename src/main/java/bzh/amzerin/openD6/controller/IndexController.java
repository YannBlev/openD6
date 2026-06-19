package bzh.amzerin.openD6.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/openD6")
public class IndexController {
    @GetMapping
    public String getIndex() {
        return "index";
    }
}
