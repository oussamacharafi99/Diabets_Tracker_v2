package com.Diabetes.Service;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Repository.ConseilRepositry;
import com.Diabetes.Repository.LectureGlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConseilsService {
    @Autowired
      ConseilRepositry conseilRepositry;
    @Autowired
    private  LectureGlycemieRepository lectureGlycemieRepository;

    public static void addConseil(Conseil ruri) {
    }


    // private final RepasRepository repasRepository;
    
//@Transactional
   

//    public void genererConseils(Utilisateur utilisateur) {
//        List<LectureGlycemie> lectures = lectureGlycemieRepository.findByUtilisateur(utilisateur);
//        List<Repas> repas = repasRepository.findByUtilisateur(utilisateur);
//
//        String message = analyserTendances(lectures, repas);
//        Conseils conseil = new Conseils(message, LocalDateTime.now(), utilisateur);
//        conseilsRepository.save(conseil);
//    }

//    private String analyserTendances(List<LectureGlycemie> lectures, List<Repas> repas) {
//        if (lectures.isEmpty()) {
//            return "Veuillez enregistrer vos lectures de glycémie pour obtenir des conseils.";
//        }
//
//        double moyenneGlycemie = lectures.stream().mapToInt(LectureGlycemie::getValeur).average().orElse(0);
//        if (moyenneGlycemie > 140) {
//            return "Votre glycémie est élevée. Essayez de réduire votre consommation de glucides.";
//        } else if (moyenneGlycemie < 70) {
//            return "Votre glycémie est basse. Assurez-vous de consommer des glucides rapidement disponibles.";
//        } else {
//            return "Votre glycémie est stable. Continuez à suivre votre régime actuel.";
//        }
//    }
}

