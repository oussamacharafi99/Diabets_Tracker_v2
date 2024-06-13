package com.Diabetes.Repository;

import com.Diabetes.Models.Conseil;
import com.Diabetes.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConseilRepositry extends JpaRepository<Conseil, Integer> {
    List<Conseil> findByUtilisateur(User utilisateur);
}
