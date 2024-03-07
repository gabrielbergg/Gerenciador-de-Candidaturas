package com.example.candidaturas.model;

import com.example.candidaturas.enums.StatusCandidatura;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Candidatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tituloVaga;
    private String nomeEmpresa;
    private String requisitosVaga;

    private String localCandidatura;

    private String descricaoVaga;

    private LocalDate dataCandidatura;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private StatusCandidatura statusCandidatura;

    @OneToMany(mappedBy = "candidatura")
    private List<Entrevista> entrevista;

    public Candidatura() {}

    public Candidatura(Long id, String tituloVaga, String nomeEmpresa, String requisitosVaga, String localCandidatura, String descricaoVaga, LocalDate dataCandidatura, StatusCandidatura statusCandidatura) {
        this.id = id;
        this.tituloVaga = tituloVaga;
        this.nomeEmpresa = nomeEmpresa;
        this.requisitosVaga = requisitosVaga;
        this.localCandidatura = localCandidatura;
        this.descricaoVaga = descricaoVaga;
        this.dataCandidatura = dataCandidatura;
        this.statusCandidatura = statusCandidatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getRequisitosVaga() {
        return requisitosVaga;
    }

    public void setRequisitosVaga(String requisitosVaga) {
        this.requisitosVaga = requisitosVaga;
    }

    public String getLocalCandidatura() {
        return localCandidatura;
    }

    public void setLocalCandidatura(String localCandidatura) {
        this.localCandidatura = localCandidatura;
    }

    public String getDescricaoVaga() {
        return descricaoVaga;
    }

    public void setDescricaoVaga(String descricaoVaga) {
        this.descricaoVaga = descricaoVaga;
    }

    public LocalDate getdataCandidatura() {
        return dataCandidatura;
    }

    public void setdataCandidatura(LocalDate dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    public StatusCandidatura getStatusCandidatura() {
        return statusCandidatura;
    }

    public void setStatusCandidatura(StatusCandidatura statusCandidatura) {
        this.statusCandidatura = statusCandidatura;
    }

    public List<Entrevista> getEntrevista() {
        return entrevista;
    }
}
