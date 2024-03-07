package com.example.candidaturas.controller;

import com.example.candidaturas.model.Entrevista;
import com.example.candidaturas.service.EntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/entrevista")
public class EntrevistaController {

    @Autowired
    EntrevistaService entrevistaService;

    @GetMapping
    public ResponseEntity<List<Entrevista>> findAll() {
        List<Entrevista> list = entrevistaService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrevista> findById(@PathVariable(value = "id") Long id) {
        Entrevista ent = entrevistaService.findById(id);

        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ent);
    }

    @PostMapping
    public ResponseEntity<Entrevista> create(@RequestBody Entrevista entrevista) {
        entrevistaService.create(entrevista);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entrevista.getId()).toUri();

        return ResponseEntity.created(uri).body(entrevista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrevista> update(@PathVariable(value = "id") Long id, @RequestBody Entrevista entrevista) {
        entrevistaService.update(id, entrevista);

        return ResponseEntity.ok().body(entrevista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        entrevistaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
