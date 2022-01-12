package com.techman.techmandatory2.service;


import com.techman.techmandatory2.model.User;
import com.techman.techmandatory2.repo.UserRepo;
import com.techman.techmandatory2.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //we use username since it ius unique
        User user = userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("No user with username: " + username));
        return new UserDetailImpl(user);
    }
}
