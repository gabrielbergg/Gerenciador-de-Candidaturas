package com.example.candidaturas.repository;

import com.example.candidaturas.model.MelhorarSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MelhorarSkillsRepository extends JpaRepository<MelhorarSkills, Long> {
}
