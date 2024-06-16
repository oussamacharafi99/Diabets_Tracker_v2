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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class GlycemieController {


    @Autowired
    private LectureService Glycemie;

    @RequestMapping(value = "/Add")
    public String home(Model model) {
        model.addAttribute("glucose", new LectureGlycemie());
        model.addAttribute("Diabetes",  Glycemie.ShowLectures());
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
        model.addAttribute("Diabetes",  Glycemie.ShowLectures());
        return "Add&ShowGlycemie";
    }


    @RequestMapping("/delete")
    public String deleteInfos(@RequestParam("id") int idS, Model model) {
        Glycemie.delete(idS);
        model.addAttribute("Diabetes",  Glycemie.ShowLectures());
        return "redirect:/Add";
    }






    // Pratie de  Rapport :


    @GetMapping("/pdf")

        public  String pdfG(Model model){
            model.addAttribute("Diabetes" ,Glycemie.ShowLectures());
            return "pdf";
    }
    @GetMapping("/chart")
    public String chart(Model model) {
        model.addAttribute("readings", Glycemie.getAllGroupedByWeek());
        return "chart";
    }

    @GetMapping("/chartDisplay")
    public String getGlucoseReadings(
            @RequestParam(value = "view", required = false, defaultValue = "week") String view,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "week", required = false) Integer week,
            Model model) {
        model.addAttribute("Diabetes" ,Glycemie.ShowLectures());
        List<LectureGlycemie> readings;

        switch (view) {
            case "month":
                readings = Glycemie.getAllGroupedByMonth();
                break;
            case "year":
                readings = Glycemie.getAllGroupedByYear();
                break;
            case "specificMonth":
                readings = Glycemie.getByYearAndMonth(year, month);
                break;
            case "specificWeek":
                readings = Glycemie.getByYearAndWeek(year, week);
                break;
            default:
                readings = Glycemie.getAllGroupedByWeek();
        }

        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (LectureGlycemie reading : readings) {
            labels.add(reading.getDate_of_Tracking().toString());
            data.add(reading.getValeur());
        }

        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "pdf";
    }

}