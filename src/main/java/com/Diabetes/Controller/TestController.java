package com.Diabetes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {
    @RequestMapping("/")
    public String test(Model model) {
        return "conseilhtml";
    }


}