package com.college_events.college_events.repository;

import com.college_events.college_events.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String tempEmail);
}
