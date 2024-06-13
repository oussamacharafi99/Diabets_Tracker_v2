package com.Diabetes.Service;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Repository.ConseilRepositry;
import com.Diabetes.Repository.LectureGlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConseilsService {
    @Autowired
    ConseilRepositry conseilRepositry;
    @Autowired
    LectureGlycemieRepository lectureGlycemieRepository;



    public List<Conseil> tousLesConseils() {
        return conseilRepositry.findAll();
    }

    public List<Conseil> obtenirConseilsParGlycemie(LectureGlycemie glycemie) {
        return conseilRepositry.findByGlycemie(glycemie);
    }

    public void genererConseils(LectureGlycemie glycemie) {
        List<Conseil> nouveauxConseils = new ArrayList<>();

        // Exemple de règles pour générer des conseils
        if (glycemie.getValeur() > 180) {
            nouveauxConseils.add(new Conseil(null, "Votre niveau de glycémie est élevé. Réduisez votre consommation de sucre.", LocalDateTime.now(), glycemie));
        } else if (glycemie.getValeur() < 70) {
            nouveauxConseils.add(new Conseil(null, "Votre niveau de glycémie est bas. Consommez des glucides rapides.", LocalDateTime.now(), glycemie));
        } else {
            nouveauxConseils.add(new Conseil(null, "Votre niveau de glycémie est normal. Continuez à suivre vos habitudes actuelles.", LocalDateTime.now(), glycemie));
        }

        conseilRepositry.saveAll(nouveauxConseils);
    }

    public void supprimerConseil(Integer id) {
        conseilRepositry.deleteById(id);
    }
}



