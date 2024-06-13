package com.Diabetes.Controller;
import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Service.ConseilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConseilController {
@Autowired
ConseilsService conseilsService;


    @RequestMapping("/conseil")
    public String conseil(Model model) {
        return "conseilhtml";
    }
    @GetMapping("/utilisateur/{id}")
    public List<Conseil> obtenirConseilsParUtilisateur(@PathVariable Integer id) {
        User utilisateur = userService.obtenirUtilisateurParId(id);
        return conseilsService.obtenirConseilsParUtilisateur(utilisateur);
    }

    @PostMapping
    public Conseil ajouterConseil(@RequestParam String message, @RequestParam Integer utilisateurId) {
        User utilisateur = userService.obtenirUtilisateurParId(utilisateurId);
        return conseilsService.ajouterConseil(message, utilisateur);
    }

    @DeleteMapping("/{id}")
    public void supprimerConseil(@PathVariable Integer id) {
        conseilsService.supprimerConseil(id);
    }
}




