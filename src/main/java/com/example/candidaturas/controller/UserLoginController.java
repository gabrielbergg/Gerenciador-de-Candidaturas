package com.example.candidaturas.controller;

import com.example.candidaturas.dto.RegistroDto;
import com.example.candidaturas.model.UserLogin;
import com.example.candidaturas.repository.UserLoginRepository;
import com.example.candidaturas.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {

//    @Autowired
//    UserLoginService userLoginService;

    @Autowired
    UserLoginRepository userLoginRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistroDto registroDto) {
        if(userLoginRepository.findByLogin(registroDto.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encriptPassword = new BCryptPasswordEncoder().encode(registroDto.password());
        UserLogin userLogin = new UserLogin(registroDto.login(), encriptPassword, registroDto.roles());

        userLoginRepository.save(userLogin);
        return ResponseEntity.ok().build();

    }
}
