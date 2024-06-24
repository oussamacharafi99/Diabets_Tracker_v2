package com.Diabetes.Controller;

import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Repas.Repas;
import com.Diabetes.Service.RepasService.Repasservice;
import com.Diabetes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RepasController {


    @Autowired Repasservice Repas;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addRepas")
    public String home(Model model) {
        model.addAttribute("repas", new Repas());
        model.addAttribute("Addrepas",  Repas.ShowRepas());

        return "Add&ShowRepas";
    }


    @PostMapping(value = "/saveRepas")
    public String save(
                       @RequestParam("id") Long id,
                       @RequestParam("repasName") String repasName,
                       @RequestParam("repasDescription") String repasDescription,
                       @RequestParam("Description") String description,
                       @RequestParam("glicydes") Double glicydes,
                       @RequestParam("type") String type,
                       @RequestParam("Ingredients") String ingredients) {

        Repas repas = new Repas();

        repas.setId(id);
        repas.setRepasName(repasName);
        repas.setRepasDescription(repasDescription);
        repas.setDescription(description);
        repas.setGlicydes(glicydes);
        repas.setType(type);
        repas.setIngredients(ingredients);


        Repas.addRepas(repas);

        return "redirect:/addRepas";
    }


    @RequestMapping("/showRepas")
    public String ShowRepas(Model model){

        model.addAttribute("Addrepas",  Repas.ShowRepas());
        return "Add&ShowRepas";
    }




}
