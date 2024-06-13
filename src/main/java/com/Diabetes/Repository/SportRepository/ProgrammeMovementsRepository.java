package com.Diabetes.Repository.SportRepository;

import com.Diabetes.Models.Sport.ProgrammeAndMovementsDTO;
import com.Diabetes.Models.Sport.ProgrammeMovements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammeMovementsRepository extends JpaRepository<ProgrammeMovements, Integer> {

@Query("SELECT new com.Diabetes.Models.Sport.ProgrammeAndMovementsDTO(p.id, p.name, p.user_id, p.startDate, p.heurs, p.endDate, p.description, m.id, m.name, m.image, m.description) " +
            "FROM ProgrammeMovements pm " +
            "INNER JOIN pm.programme p " +
            "INNER JOIN pm.movements m " +
            "WHERE p.id = :programmeId")
List<ProgrammeAndMovementsDTO> findProgrammeAndMovementsByProgrammeId(@Param("programmeId") Integer programmeId);
}
