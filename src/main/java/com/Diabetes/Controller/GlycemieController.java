package com.Diabetes.Controller;


import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Controller
public class GlycemieController {


    @Autowired
    private LectureService Glycemie;

    @RequestMapping(value = "/Add")
    public String home(Model model) {
        model.addAttribute("glucose", new LectureGlycemie());
        model.addAttribute("Diabetes",  Glycemie.ShowDiabetes());
        return "Add&ShowGlycemie";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam("date_of_tracking") String date_of_Tracking,
                       @RequestParam("time_of_tracking") String time_of_tracking,
                       @RequestParam("value_glucose") String value_Glucose) {


        LocalDate date = LocalDate.parse(date_of_Tracking);
        LocalTime time = LocalTime.parse(time_of_tracking);
        double value = Double.parseDouble(value_Glucose);


        LectureGlycemie Lecture = new LectureGlycemie();
        Lecture.setDate_of_Tracking(Date.valueOf(date));
        Lecture.setTime(Time.valueOf(time));
        Lecture.setValeur(value);


        Glycemie.addLecture(Lecture);

        return "redirect:/Add";
    }




    @RequestMapping("/ShowInfo")
    public String show(Model model){
        // model.addAttribute("diabete",new GlucoseReading());
        model.addAttribute("Diabetes",  Glycemie.ShowDiabetes());
        return "Add&ShowGlycemie";
    }


    @RequestMapping("/delete")
    public String deleteInfos(@RequestParam("id") int idS, Model model) {
        Glycemie.delete(idS);
        model.addAttribute("Diabetes",  Glycemie.ShowDiabetes());
        return "Show";
    }


}