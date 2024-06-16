package com.Diabetes.Repository.Repas;


import com.Diabetes.Models.Repas.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepasRepository extends JpaRepository<Repas, Integer>{

}
