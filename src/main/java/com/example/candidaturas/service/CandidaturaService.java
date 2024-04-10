package com.example.candidaturas.service;

import com.example.candidaturas.controller.CandidaturaController;
import com.example.candidaturas.controller.EntrevistaController;
import com.example.candidaturas.enums.StatusCandidatura;
import com.example.candidaturas.model.Candidatura;
import com.example.candidaturas.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CandidaturaService {

    @Autowired
    CandidaturaRepository canditRepository;

    public List<Candidatura> semResposta() {
        List<Candidatura> list =  new ArrayList<>();

        for (Candidatura c: canditRepository.findAll()) {
            if(LocalDate.now().isAfter(c.getdataCandidatura().plusMonths(1))  ||
                    LocalDate.now().isEqual(c.getdataCandidatura().plusMonths(1))) {
                c.setStatusCandidatura(StatusCandidatura.SEM_RESPOSTA);
                list.add(c);
                c.add(linkTo(methodOn(CandidaturaController.class).findById(c.getId())).withSelfRel());
            }
        }
        return list;
    }

    public List<Candidatura> aguardandoResposta() {
        List<Candidatura> list =  new ArrayList<>();

        for (Candidatura c: canditRepository.findAll()) {
            if(LocalDate.now().isBefore(c.getdataCandidatura().plusMonths(1)) &&
                c.getStatusCandidatura() == StatusCandidatura.AGUARDANDO_RESPOSTA) {
                c.setStatusCandidatura(StatusCandidatura.AGUARDANDO_RESPOSTA);
                list.add(c);
            }
        }
        return list;
    }

    public List<Candidatura> respostaPositiva() {
        List<Candidatura> list =  new ArrayList<>();

        for (Candidatura c: canditRepository.findAll()) {
            if(c.getStatusCandidatura() == StatusCandidatura.RESPOSTA_POSITIVA) {
                list.add(c);
            }
        }
        return list;
    }

    public List<Candidatura> respostaNegativa() {
        List<Candidatura> list =  new ArrayList<>();

        for (Candidatura c: canditRepository.findAll()) {
            if(c.getStatusCandidatura() == StatusCandidatura.RESPOSTA_NEGATIVA) {
                list.add(c);
            }
        }
        return list;
    }

    public Candidatura findById(Long id) {
        return canditRepository.findById(id).orElseThrow();
    }

    public Candidatura create(Candidatura candit) {
        candit.setdataCandidatura(LocalDate.now());
        candit.setStatusCandidatura(StatusCandidatura.AGUARDANDO_RESPOSTA);
        return canditRepository.save(candit);
    }

    public Candidatura update(Long id, Candidatura candit) {
        Candidatura candidatura = canditRepository.findById(id).orElseThrow();

        candidatura.setTituloVaga(candit.getTituloVaga());
        candidatura.setNomeEmpresa(candit.getNomeEmpresa());
        candidatura.setLocalCandidatura(candit.getLocalCandidatura());
        candidatura.setRequisitosVaga(candit.getRequisitosVaga());
        candidatura.setDescricaoVaga(candit.getDescricaoVaga());
        candidatura.setStatusCandidatura(candit.getStatusCandidatura());

        canditRepository.save(candidatura);

        return candidatura;
    }

    public void delete(Long id) {
        canditRepository.deleteById(id);
    }
}