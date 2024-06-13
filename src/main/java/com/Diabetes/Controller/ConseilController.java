package com.Diabetes.Controller;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Service.ConseilsService;
import com.Diabetes.Service.LectureService;
import com.Diabetes.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/conseils")
public class ConseilController {
@Autowired
ConseilsService conseilsService;
@Autowired
UserService userService;
@Autowired
    LectureService lectureService;

    @GetMapping
    public String afficherConseils(Model model) {
        List<Conseil> conseils = conseilsService.tousLesConseils();
        model.addAttribute("conseils", conseils);
        return "conseilhtml"; // correspond à conseils.html
    }

    @PostMapping("/generer")
    public String genererConseils(@RequestParam Integer glycemieId) {
        LectureGlycemie glycemie = lectureService.findById(glycemieId);
        conseilsService.genererConseils(glycemie);
        return "redirect:/conseils";
    }

    @PostMapping("/{id}")
    public String supprimerConseil(@PathVariable Integer id) {
        conseilsService.supprimerConseil(id);
        return "redirect:/conseils";
    }
}

