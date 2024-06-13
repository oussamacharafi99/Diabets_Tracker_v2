package com.Diabetes.Repository.SportRepository;
import com.Diabetes.Models.Sport.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementsRepository extends JpaRepository<Movements , Integer> {
    List<Movements> findAll(Movements movements);
}
