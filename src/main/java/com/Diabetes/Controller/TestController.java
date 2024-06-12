package com.Diabetes.Controller;

import com.Diabetes.Models.test;
import com.Diabetes.Repository.TestRepository;
import com.Diabetes.Service.TestImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    TestImp testImp;

    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("test", new test());
        testImp.addTest(new test(  "salma"));
        return "index";
    }

//    @PostMapping("/")
//    public String View(test test , Model model) {
//        test test1 = new test();
//        return "redirect:/";
//    }
    //    @PostMapping("/")
//    public String View(test test , Model model) {
//        test test1 = new test();
//        return "redirect:/";
//    }


}