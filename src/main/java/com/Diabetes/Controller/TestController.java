package com.Diabetes.Controller;
import com.Diabetes.Models.Sport.ProgrammeAndMovementsDTO;
import com.Diabetes.Service.ServiceSport.ServiceSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TestController {

    @Autowired
    ServiceSport serviceSport;

    @RequestMapping("/")
    public String test(Model model) {
        List<ProgrammeAndMovementsDTO> programmeAndMovementsList = serviceSport.getProgrammeAndMovementsByProgrammeId(1);
        model.addAttribute("programmeAndMovementsList", programmeAndMovementsList);
        return "index";
    }


}