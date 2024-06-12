package com.Diabetes.Repository;

import com.Diabetes.Models.Conseil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseilRepositry extends JpaRepository<Conseil, Integer> {

}
