package com.example.candidaturas.service;

import com.example.candidaturas.model.UserLogin;
import com.example.candidaturas.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserLoginService implements UserDetailsService {

    @Autowired
    UserLoginRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserLogin userLogin = this.userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(userLogin.getLogin(), userLogin.getPassword(), userLogin.getAuthorities());
    }

    public UserLogin findById(Long id) {
        UserLogin userLogin = userRepository.findById(id).orElseThrow();;

        return userLogin;
    }
}
