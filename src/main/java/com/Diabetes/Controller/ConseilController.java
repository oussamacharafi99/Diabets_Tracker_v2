package com.Diabetes.Controller;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Service.ConseilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ConseilController {

    @Autowired
    ConseilsService conseilsService;
    @RequestMapping("/")
    public String conseil(Model model) {
        model.addAttribute("Conseil", new Conseil());
        ConseilsService.addConseil(new Conseil("ruri"));
        return "conseilhtml";
    }


}
