package com.Diabetes.Repository.SportRepository;
import com.Diabetes.Models.Sport.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {
    List<Programme> findAll(Programme programme);
}
