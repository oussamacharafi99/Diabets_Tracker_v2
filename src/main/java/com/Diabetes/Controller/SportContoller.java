package com.Diabetes.Controller;
import com.Diabetes.Models.Sport.*;
import com.Diabetes.Repository.SportRepository.ProgrammeRepository;
import com.Diabetes.Service.ServiceSport.ServiceSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SportContoller {

    @Autowired
    ServiceSport serviceSport;


    @RequestMapping("/show_programme")
    public String programme(@Param("id") Integer id, Model model) {
        List<ProgrammeAndMovementsDTO> programmeAndMovementsList = serviceSport.getProgrammeAndMovementsByProgrammeId(id);
        model.addAttribute("programmeAndMovementsList", programmeAndMovementsList);
        model.addAttribute("programme", serviceSport.getProgrammeById(id));
        return "Front_end_sport/showProgramme";
    }

    @RequestMapping("/sport")
    public String sport(Model model , Programme programme) {
        model.addAttribute("programme", serviceSport.getPro());
        serviceSport.deletePro(3);
        return "Front_end_sport/SportHome";
    }

    @RequestMapping("/addProgram")
    public String addprograme(Model model , Programme programme) {
        model.addAttribute("programme", programme);
        return "Front_end_sport/SportHome";
    }

    @PostMapping("/saveProgramme")
    public String save(@ModelAttribute("programme") Programme programme ) {
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
    @PostMapping("/addMovementToProgram")
    public String addMovementToProgram(@RequestParam("programme_id") Integer programmeId, @RequestParam("movement_id") Integer movementId) {
        Programme programme = serviceSport.getProgrammeById(programmeId);
        Movements movement = serviceSport.getMovements().stream()
                .filter(m -> m.getId().equals(movementId))
                .findFirst()
                .orElseThrow();

        PM pmId = new PM(programmeId, movementId);
        ProgrammeMovements programmeMovements = new ProgrammeMovements(pmId, programme, movement);
        serviceSport.saveProMov(programmeMovements);
        return "redirect:/addMovementToProgramme";
    }

    @RequestMapping("/programmes")
    public List<Programme> programmeCalendar() {
        for (Programme programme : serviceSport.getPro()){
            System.out.println(programme.getDescription());
        }
        return serviceSport.getPro();
    }
}