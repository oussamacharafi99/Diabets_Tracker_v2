package com.Diabetes.Controller;


import com.Diabetes.Models.Conseil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ConseilController {


    @RequestMapping("/")
    public String conseil(Model model) {
        return "conseilhtml";
    }



}

