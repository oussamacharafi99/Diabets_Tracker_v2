package com.Diabetes.Repository.UserRepository;
import com.Diabetes.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteById(Long id);
    Optional<User> findById(Long id);
}
