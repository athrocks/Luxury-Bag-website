package com.scatch.scatch.service;

import com.scatch.scatch.model.UserModel;
import com.scatch.scatch.model.UserPrincipal;
import com.scatch.scatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("Searching for user: " + email);
        UserModel user = userRepo.findByEmail(email);

        if(user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }

        System.out.println("User Found");
        return new UserPrincipal(user);
    }
}

