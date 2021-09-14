package com.college_events.college_events.service;

import java.util.List;

import com.college_events.college_events.entities.User;
import com.college_events.college_events.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    // PasswordEncoder passwordEncoder;


    @Override
    public User fetchEmailAndPassword(String tempEmail, String tempPassword) {
        return loginRepository.findByEmailAndPassword(tempEmail, tempPassword);
    }

    @Override
    public User fetchByEmail(String tempEmail) {
        return loginRepository.findByEmail(tempEmail);
    }

    @Override
    public User registerUser(User user) {
        // this.passwordEncoder = new BCryptPasswordEncoder();
        // this.passwordEncoder.encode(user.getPassword());
        return loginRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return loginRepository.findAll();
    }
}
