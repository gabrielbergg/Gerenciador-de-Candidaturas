package com.example.candidaturas.controller;

import com.example.candidaturas.model.MelhorarSkills;
import com.example.candidaturas.service.MelhorarSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class MelhorarSkillsController {

    @Autowired
    MelhorarSkillsService skillsService;

    @GetMapping
    public ResponseEntity<List<MelhorarSkills>> findAll() {
        List<MelhorarSkills> list = skillsService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
