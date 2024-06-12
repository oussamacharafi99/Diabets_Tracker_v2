package com.Diabetes.Controller;

import com.Diabetes.Service.ConseilsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conseils")
public class ConseilController {
    private final ConseilsService conseilsService;
    private final UtilisateurRepository utilisateurRepository;

    public ConseilController(ConseilsService conseilsService, UtilisateurRepository utilisateurRepository) {
        this.conseilsService = conseilsService;
        this.utilisateurRepository = utilisateurRepository;
    }
}
