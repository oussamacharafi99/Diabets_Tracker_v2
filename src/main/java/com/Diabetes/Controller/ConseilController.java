package com.Diabetes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConseilController {

    @RequestMapping("/conseil")
    public String conseil(Model model) {
        return "conseilhtml";
    }
}
