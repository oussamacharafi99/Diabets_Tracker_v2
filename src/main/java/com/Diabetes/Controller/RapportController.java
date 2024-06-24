package com.Diabetes.Controller;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Rapport;
import com.Diabetes.Models.Repas.Repas;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Service.ConseilsService;
import com.Diabetes.Service.LectureService;
import com.Diabetes.Service.RapportService;
import com.Diabetes.Service.RepasService.Repasservice;
import com.Diabetes.Service.ServiceSport.ServiceSport;
import com.Diabetes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private LectureService glycemieService;
    @Autowired
    private RapportService rapportService;
    @Autowired
    private ConseilsService conseilsService;

    @Autowired
    private UserService userService; // Assuming you have a UserService to fetch user details
    @Autowired
    private Repasservice repasservice;
    @GetMapping("/display")
    public String displayData(
            @RequestParam(value = "view", required = false, defaultValue = "week") String view,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "week", required = false) Integer week,
            Model model) {

        // Add Diabetes data
        List<LectureGlycemie> diabetes = glycemieService.ShowLectures();
        model.addAttribute("Diabetes", diabetes);
       List<Repas> repas = repasservice.ShowRepas();
        model.addAttribute("repas", repas);
        // Add User data (assuming user ID is 1 for demonstration)
        User user = userService.getUserById(1L);
        model.addAttribute("user", user);
//        model.addAttribute("programme", serviceSport.getPro());
        // Add Conseils data
        List<Conseil> conseils = conseilsService.tousLesConseils();
        model.addAttribute("conseils", conseils);
        List<Rapport> rapports = rapportService.getRapportsByUser(user);
        model.addAttribute("rapports", rapports);
        // Determine the readings based on the view parameter
        List<LectureGlycemie> readings;
        switch (view) {
            case "month":
                readings = glycemieService.getAllGroupedByMonth();
                break;
            case "year":
                readings = glycemieService.getAllGroupedByYear();
                break;
            case "specificMonth":
                readings = glycemieService.getByYearAndMonth(year, month);
                break;
            case "specificWeek":
                readings = glycemieService.getByYearAndWeek(year, week);
                break;
            default:
                readings = glycemieService.getAllGroupedByWeek();
        }

        // Prepare labels and data for the chart
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();
        for (LectureGlycemie reading : readings) {
            labels.add(reading.getDate_of_Tracking().toString());
            data.add(reading.getValeur());
        }

        // Add labels and data to the model
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);

        return "pdf";  
    }

    @Controller
    @RequestMapping("/rapport")
    public static class RapportController {

        @Autowired
        private LectureService glycemieService;
        @Autowired
        private RapportService rapportService;
        @Autowired
        private ConseilsService conseilsService;
        @Autowired
        private ServiceSport serviceSport;
        @Autowired
        private UserService userService; // Assuming you have a UserService to fetch user details
        @Autowired
        private Repasservice repasservice;

        @GetMapping("/display")
        public String displayData(
                @RequestParam(value = "view", required = false, defaultValue = "week") String view,
                @RequestParam(value = "year", required = false) Integer year,
                @RequestParam(value = "month", required = false) Integer month,
                @RequestParam(value = "week", required = false) Integer week,
                Model model) {

            // Add Diabetes data
            List<LectureGlycemie> diabetes = glycemieService.ShowLectures();
            model.addAttribute("Diabetes", diabetes);
           List<Repas> repas = repasservice.ShowRepas();
            model.addAttribute("repas", repas);
            // Add User data (assuming user ID is 1 for demonstration)
            User user = userService.getUserById(1L);
            model.addAttribute("user", user);
            model.addAttribute("programme", serviceSport.getProgrammeById(1));

            // Add Conseils data
            List<Conseil> conseils = conseilsService.tousLesConseils();
            model.addAttribute("conseils", conseils);
            List<Rapport> rapports = rapportService.getRapportsByUser(user);
            model.addAttribute("rapports", rapports);
            // Determine the readings based on the view parameter
            List<LectureGlycemie> readings;
            switch (view) {
                case "month":
                    readings = glycemieService.getAllGroupedByMonth();
                    break;
                case "year":
                    readings = glycemieService.getAllGroupedByYear();
                    break;
                case "specificMonth":
                    readings = glycemieService.getByYearAndMonth(year, month);
                    break;
                case "specificWeek":
                    readings = glycemieService.getByYearAndWeek(year, week);
                    break;
                default:
                    readings = glycemieService.getAllGroupedByWeek();
            }

            // Prepare labels and data for the chart
            List<String> labels = new ArrayList<>();
            List<Double> data = new ArrayList<>();
            for (LectureGlycemie reading : readings) {
                labels.add(reading.getDate_of_Tracking().toString());
                data.add(reading.getValeur());
            }

            // Add labels and data to the model
            model.addAttribute("labels", labels);
            model.addAttribute("data", data);

            return "pdf";
        }
    }
}
