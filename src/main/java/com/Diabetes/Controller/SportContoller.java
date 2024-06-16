package com.Diabetes.Controller;
import com.Diabetes.Models.Sport.Programme;
import com.Diabetes.Models.Sport.ProgrammeAndMovementsDTO;
import com.Diabetes.Service.ServiceSport.ServiceSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SportContoller {

    @Autowired
    ServiceSport serviceSport;

    @RequestMapping("/")
    public String test(Model model) {
        List<ProgrammeAndMovementsDTO> programmeAndMovementsList = serviceSport.getProgrammeAndMovementsByProgrammeId(1);
        model.addAttribute("programmeAndMovementsList", programmeAndMovementsList);
        return "index";
    }


    @RequestMapping("/sport")
    public String sport(Model model , Programme programme) {
        return "Front_end_sport/SportHome";
    }
    @RequestMapping("/addProgram")
    public String addprograme(Model model , Programme programme) {
        model.addAttribute("programme", programme);
        return "Front_end_sport/SportHome";
    }

    @PostMapping("/saveProgramme")
    public String save(@ModelAttribute("programme") Programme programme, Model model ) {
        serviceSport.savePro(programme);
        return "redirect:/addMovementToProgramme";
    }

    @RequestMapping("/addMovementToProgramme")
    public String addMovementToProgramme(Model model) {
        // Supposons que l'utilisateur a l'ID 1 pour cet exemple
        Programme latestProgramme = serviceSport.getLatestProgramme(1);
        model.addAttribute("programme", latestProgramme);
        return "Front_end_sport/addMovementToProgramme";
    }


}