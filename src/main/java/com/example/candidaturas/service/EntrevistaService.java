package com.example.candidaturas.service;

import com.example.candidaturas.controller.EntrevistaController;
import com.example.candidaturas.model.Entrevista;
import com.example.candidaturas.repository.EntrevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class EntrevistaService {

    @Autowired
    EntrevistaRepository entrevistaRepository;

    public List<Entrevista> findAll() {
        List<Entrevista> list = entrevistaRepository.findAll();

        for (Entrevista ent:list) {
            ent.add(linkTo(methodOn(EntrevistaController.class).findById(ent.getId())).withSelfRel());
        }
        return list;
    }

    public Entrevista findById(Long id) {

        Entrevista entrevista = entrevistaRepository.findById(id).orElseThrow();
        entrevista.add(linkTo(methodOn(EntrevistaController.class).findAll()).withSelfRel());

        return entrevista;
    }

    public Entrevista create(Entrevista entrevista) {
        return entrevistaRepository.save(entrevista);
    }

    public Entrevista update(Long id, Entrevista entrevista) {
        Entrevista ent = entrevistaRepository.findById(id).orElseThrow();

        ent.setPergunta(entrevista.getPergunta());
        ent.setResposta(entrevista.getResposta());

        return entrevistaRepository.save(ent);
    }

    public void delete(Long id) {
        entrevistaRepository.deleteById(id);
    }



}
