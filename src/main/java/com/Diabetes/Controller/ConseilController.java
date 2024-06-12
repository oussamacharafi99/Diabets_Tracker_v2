package com.Diabetes.Controller;


import com.Diabetes.Models.Conseil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConseilController {


    @RequestMapping("/conseil")
    public String conseil(Model model) {
        return "conseilhtml";
    }