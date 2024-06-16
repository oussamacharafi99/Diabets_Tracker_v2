package com.Diabetes.Repository;

import com.Diabetes.Models.Rapport;
import com.Diabetes.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RapportRepository extends JpaRepository<Rapport, Integer> {

    List<Rapport> findByUtilisateur(User user);

    List<Rapport> findByDateGenerationAfter(LocalDateTime date);
}
