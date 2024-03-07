package com.example.candidaturas.repository;

import com.example.candidaturas.model.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistaRepository extends JpaRepository<Entrevista, Long> {
}
