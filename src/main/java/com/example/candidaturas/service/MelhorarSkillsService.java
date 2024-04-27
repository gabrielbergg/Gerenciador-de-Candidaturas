package com.example.candidaturas.service;

import com.example.candidaturas.model.MelhorarSkills;
import com.example.candidaturas.repository.MelhorarSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MelhorarSkillsService {

    @Autowired
    private MelhorarSkillsRepository skillsRepository;

    public List<MelhorarSkills> findAll() {
        return skillsRepository.findAll();
    }

    public MelhorarSkills findById(Long id) {
        return skillsRepository.findById(id).orElseThrow();
    }

    public MelhorarSkills create(MelhorarSkills melhorarSkills) {
        return skillsRepository.save(melhorarSkills);
    }

    public MelhorarSkills update(Long id, MelhorarSkills melhorarSkills) {
        MelhorarSkills skills = findById(id);
        skills.setMelhorias(melhorarSkills.getMelhorias());

        return skillsRepository.save(skills);
    }

    public void delete(Long id) {
        skillsRepository.deleteById(id);
    }

}
