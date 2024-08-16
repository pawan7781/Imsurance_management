package com.project.insurance.service;


import com.project.insurance.model.User;
import com.project.insurance.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user) {
       user.setPassword( encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
