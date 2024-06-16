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

    @RequestMapping("/show_programme/{id}")
    public String test(@PathVariable("id") Integer id, Model model) {
        List<ProgrammeAndMovementsDTO> programmeAndMovementsList = serviceSport.getProgrammeAndMovementsByProgrammeId(id);
        model.addAttribute("programmeAndMovementsList", programmeAndMovementsList);
        model.addAttribute("programme", serviceSport.getProgrammeById(id));
        return "Front_end_sport/showProgramme";
    }


    @RequestMapping("/sport")
    public String sport(Model model , Programme programme) {
        model.addAttribute("programme", serviceSport.getPro());
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
        Programme latestProgramme = serviceSport.getLatestProgramme(1);
        model.addAttribute("programme", latestProgramme);
        model.addAttribute("movements", serviceSport.getMovements());
        return "Front_end_sport/addMovementToProgramme";
    }


}