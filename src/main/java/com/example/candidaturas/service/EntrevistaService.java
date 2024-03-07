package com.example.candidaturas.service;

import com.example.candidaturas.model.Entrevista;
import com.example.candidaturas.repository.EntrevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrevistaService {

    @Autowired
    EntrevistaRepository entrevistaRepository;

    public List<Entrevista> findAll() {
        return entrevistaRepository.findAll();
    }

    public Entrevista findById(Long id) {
        return entrevistaRepository.findById(id).orElseThrow();
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
