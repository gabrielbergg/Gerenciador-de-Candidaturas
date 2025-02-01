package com.example.candidaturas.controller;

import com.example.candidaturas.dto.AutheticationDto;
import com.example.candidaturas.dto.RegistroDto;
import com.example.candidaturas.dto.ResponseDto;
import com.example.candidaturas.dto.UserDto;
import com.example.candidaturas.model.Candidatura;
import com.example.candidaturas.model.UserLogin;
import com.example.candidaturas.repository.UserLoginRepository;
import com.example.candidaturas.service.TokenService;
import com.example.candidaturas.service.UserLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/security")
public class UserLoginController {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    TokenService tokenService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistroDto body) {
        Optional<UserLogin> user = this.userLoginRepository.findByLogin(body.login());

        if(user.isEmpty()) {
            UserLogin newUser = new UserLogin();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setRoles(body.roles());
            newUser.setLogin(body.login());
            newUser.setName(body.name());
            this.userLoginRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDto(newUser.getLogin(), newUser.getRoles(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AutheticationDto body) {
        UserLogin user = this.userLoginRepository.findByLogin(body.login()).orElseThrow(() -> new RuntimeException("User not found"));

        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new AutheticationDto(user.getLogin(), user.getRoles(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> users(@PathVariable Long id) {
        UserLogin userLogin = userLoginService.findById(id);

        UserDto userDto = new UserDto(userLogin.getName(), userLogin.getRoles(), userLogin.getCandidatura());

        return ResponseEntity.ok().body(userDto);
    }
}
