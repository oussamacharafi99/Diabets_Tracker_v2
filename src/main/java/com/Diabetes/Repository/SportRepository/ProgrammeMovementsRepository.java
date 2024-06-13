package com.Diabetes.Repository.SportRepository;

import com.Diabetes.Models.Sport.ProgrammeMovements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgrammeMovementsRepository extends JpaRepository<ProgrammeMovements , Integer> {
    List<ProgrammeMovements> findAll(ProgrammeMovements programmeMovements);
}
