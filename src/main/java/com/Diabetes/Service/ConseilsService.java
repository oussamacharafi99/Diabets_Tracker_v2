package com.Diabetes.Service;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Repository.ConseilRepositry;
import com.Diabetes.Repository.LectureGlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConseilsService {
    @Autowired
    ConseilRepositry conseilRepositry;
    @Autowired
    LectureGlycemieRepository lectureGlycemieRepository;

    public List<Conseil> obtenirConseilsParUtilisateur(User utilisateur) {
        return conseilRepositry.findByUtilisateur(utilisateur);
    }

    public Conseil ajouterConseil(String message, User utilisateur) {
        Conseil conseil = new Conseil();
        conseil.setMessage(message);
        conseil.setDateHeure(LocalDateTime.now());
        conseil.setUtilisateur(utilisateur);
        return conseilRepositry.save(conseil);
    }

    public void supprimerConseil(Integer id) {
        conseilRepositry.deleteById(id);
    }
}



