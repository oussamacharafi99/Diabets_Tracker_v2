package com.Diabetes.Controller;


import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;





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
    public String save(@RequestParam("date_of_Tracking") String date_of_Tracking,
                       @RequestParam("time_of_tracking") String time_of_tracking,
                       @RequestParam("value_Glucose") String value_Glucose) {


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






    @GetMapping("/graph")
    public String showGraph(Model model) {
        List<LectureGlycemie> lectures = Glycemie.ShowDiabetes();
        model.addAttribute("lectures", lectures);
        return "Graph";
    }

    @RequestMapping("/filter")
    public String filter(@RequestParam("type") String type, Model model) {
        List<LectureGlycemie> lectures = Glycemie.ShowDiabetes();
        LocalDate now = LocalDate.now();
        List<LectureGlycemie> filteredLectures;

        if (type.equals("week")) {
            filteredLectures = lectures.stream()
                    .filter(lecture -> ((java.sql.Date) lecture.getDate_of_Tracking()).toLocalDate().isAfter(now.minusWeeks(1)))
                    .collect(Collectors.toList());
        } else if (type.equals("month")) {
            filteredLectures = lectures.stream()
                    .filter(lecture -> ((java.sql.Date) lecture.getDate_of_Tracking()).toLocalDate().isAfter(now.minusMonths(1)))
                    .collect(Collectors.toList());
        } else {
            filteredLectures = lectures;
        }

        model.addAttribute("lectures", filteredLectures);
        return "Add&ShowGlycemie";

}
}