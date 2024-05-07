package com.example.candidaturas.repository;

import com.example.candidaturas.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserDetails findByLogin(String login);
}
