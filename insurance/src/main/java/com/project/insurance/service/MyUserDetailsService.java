package com.project.insurance.service;


import com.project.insurance.model.UserPrinciple;
import com.project.insurance.model.User;
import com.project.insurance.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= repo.findByUsername( username);
       if(user==null)
       {
           System.out.println("user not found");
           throw new UsernameNotFoundException("404 not found");
       }
        return new UserPrinciple(user);
    }
}
