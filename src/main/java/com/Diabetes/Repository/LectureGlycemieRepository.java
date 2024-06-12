package com.Diabetes.Repository;
import com.Diabetes.Models.LectureGlycemie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureGlycemieRepository extends JpaRepository<LectureGlycemie, Integer> {
}
