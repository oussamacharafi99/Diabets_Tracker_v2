package com.Diabetes.Repository.SportRepository;

import com.Diabetes.Models.Sport.ProgrammeMovements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammeMovementsRepository extends JpaRepository<ProgrammeMovements , Integer> {
    List<ProgrammeMovements> findAll(ProgrammeMovements programmeMovements);
}
