package com.example.candidaturas.controller;

import com.example.candidaturas.model.Candidatura;
import com.example.candidaturas.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    @Autowired
    CandidaturaService canditService;

    @GetMapping("/semResposta")
    public ResponseEntity<List<Candidatura>> semResposta() {
        List<Candidatura> list = canditService.semResposta();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/aguardandoResposta")
    public ResponseEntity<List<Candidatura>> aguardandoResposta() {
        List<Candidatura> list = canditService.aguardandoResposta();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/respostaPositiva")
    public ResponseEntity<List<Candidatura>> respostaPositiva() {
        List<Candidatura> list = canditService.respostaPositiva();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/respostaNegativa")
    public ResponseEntity<List<Candidatura>> respostaNegativa() {
        List<Candidatura> list = canditService.respostaNegativa();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{st}/{id}")
    public ResponseEntity<Candidatura> findById(@PathVariable(value = "id") Long id) {
        Candidatura cand = canditService.findById(id);
        String st = cand.getStatusCandidatura().getStatus();


        if(cand != null) {
            return ResponseEntity.ok().body(canditService.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Candidatura> create(@RequestBody Candidatura candidatura) {
        canditService.create(candidatura);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(candidatura.getId()).toUri();

        return ResponseEntity.created(uri).body(candidatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidatura> update(@PathVariable(value = "id") Long id, @RequestBody Candidatura candidatura) {
        canditService.update(id, candidatura);

        return ResponseEntity.ok().body(candidatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value =  "id") Long id) {
        canditService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
