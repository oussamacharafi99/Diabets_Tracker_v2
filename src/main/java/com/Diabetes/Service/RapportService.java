package com.Diabetes.Service;

import com.Diabetes.Models.Rapport;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    public List<Rapport> getRapportsByUser(User user) {
        return rapportRepository.findByUtilisateur(user);
    }

    public List<Rapport> getRapportsGeneratedAfter(LocalDateTime date) {
        return rapportRepository.findByDateGenerationAfter(date);
    }

    public void saveRapport(Rapport rapport) {
        rapportRepository.save(rapport);
    }

    // Add more methods as needed

}
