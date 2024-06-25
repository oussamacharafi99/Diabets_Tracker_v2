package com.Diabetes.Controller;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Rapport;
import com.Diabetes.Models.Repas.Repas;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Service.*;
import com.Diabetes.Service.RepasService.Repasservice;
import com.Diabetes.Service.ServiceSport.ServiceSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExportService exportService;
    @Autowired
    private LectureService glycemieService;
    @Autowired
    private ConseilsService conseilsService;
    @Autowired
    private ServiceSport serviceSport;
    @Autowired
    private Repasservice repasservice;
    @GetMapping("/export/pdf")
    public ResponseEntity<InputStreamResource> exportRapportToPDF() throws IOException {
        User user = userService.getUserById(1L);
        List<Rapport> rapports = rapportService.getRapportsByUser(user);
        byte[] pdfContent = exportService.exportToPDF(rapports, user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=rapport_glycemie.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(new ByteArrayInputStream(pdfContent)));
    }

    @GetMapping("/export/word")
    public ResponseEntity<InputStreamResource> exportRapportToWord() throws IOException {
        User user = userService.getUserById(1L);
        List<Rapport> rapports = rapportService.getRapportsByUser(user);
        byte[] wordContent = exportService.exportToWord(rapports, user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=rapport_glycemie.docx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(new ByteArrayInputStream(wordContent)));
    }



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

