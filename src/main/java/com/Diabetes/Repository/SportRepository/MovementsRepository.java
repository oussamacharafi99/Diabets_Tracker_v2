package com.Diabetes.Repository.SportRepository;
import com.Diabetes.Models.Sport.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovementsRepository extends JpaRepository<Movements , Integer> {
    List<Movements> findAll(Movements movements);
}
