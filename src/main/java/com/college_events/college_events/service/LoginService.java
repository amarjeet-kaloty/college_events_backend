package com.college_events.college_events.service;

import com.college_events.college_events.entities.User;

import java.util.List;

public interface LoginService {
    public User fetchEmailAndPassword(String tempEmail, String tempPassword);

    public User fetchByEmail(String tempEmail);

    public User registerUser(User user);

    public List<User> fetchAllUsers();
}
