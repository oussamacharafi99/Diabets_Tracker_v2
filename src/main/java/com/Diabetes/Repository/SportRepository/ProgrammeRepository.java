package com.Diabetes.Repository.SportRepository;
import com.Diabetes.Models.Sport.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {
//    @Query(value = "SELECT p.id FROM Programme p WHERE p.user_id = :userId ORDER BY p.id DESC LIMIT 1", nativeQuery = true)
//    Integer findLatestProgrammeIdByUserId(@Param("userId") Integer userId);
@Query(value = "SELECT * FROM Programme p WHERE p.user_id = :userId ORDER BY p.id DESC LIMIT 1", nativeQuery = true)
Programme findLatestProgrammeByUserId(@Param("userId") Integer userId);
}
