package com.college_events.college_events.controller;

import java.util.List;

import com.college_events.college_events.entities.User;
import com.college_events.college_events.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User login(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User obj = null;
        if(tempEmail != null && tempPassword != null){
            obj = loginService.fetchEmailAndPassword(tempEmail, tempPassword);
        }
        if(obj == null){
            throw new Exception("Credentials are incorrect.");
        }
        return obj;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User register(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            User userEmail = loginService.fetchByEmail(tempEmail);
            if(userEmail != null){
                throw new Exception("User already exists.");
            }
        }
        User obj = null;
        obj = loginService.registerUser(user);
        return obj;
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> fetchAllUsers(){
        return loginService.fetchAllUsers();
    }
}
