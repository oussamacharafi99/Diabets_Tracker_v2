package com.Diabetes.Controller;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Service.ConseilsService;
import com.Diabetes.Service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Graphique")
public class GraphiqueController {
    @Autowired
    private LectureService Glycemie;
    @Autowired
    ConseilsService conseilsService;
    @GetMapping("/pdf")

    public  String pdfG(Model model){
        model.addAttribute("Diabetes" ,Glycemie.ShowDiabetes());
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
        List<Conseil> conseils = conseilsService.tousLesConseils();
        model.addAttribute("conseils", conseils);
        model.addAttribute("Diabetes" ,Glycemie.ShowDiabetes());
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
