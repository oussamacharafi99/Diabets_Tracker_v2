package com.Diabetes.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConseilController {
}



    @RequestMapping("/conseil")
    public String conseil(Model model) {
        return "conseilhtml";
    }
}

