package com.example.candidaturas.model;

import com.example.candidaturas.enums.StatusCandidatura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Candidatura extends RepresentationModel<Candidatura> implements Serializable {

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

    @OneToMany(mappedBy = "candidatura")
    private List<MelhorarSkills> skillsParaMelhorar;

    @ManyToOne
    @JoinColumn(name = "userLogin_id")
    @JsonIgnore
    private UserLogin userLogin;

    public Candidatura() {}

    public Candidatura(Long id, String tituloVaga, String nomeEmpresa, String requisitosVaga, String localCandidatura, String descricaoVaga, LocalDate dataCandidatura, StatusCandidatura statusCandidatura, UserLogin userLogin) {
        this.id = id;
        this.tituloVaga = tituloVaga;
        this.nomeEmpresa = nomeEmpresa;
        this.requisitosVaga = requisitosVaga;
        this.localCandidatura = localCandidatura;
        this.descricaoVaga = descricaoVaga;
        this.dataCandidatura = dataCandidatura;
        this.statusCandidatura = statusCandidatura;
        this.userLogin = userLogin;
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

    public List<MelhorarSkills> getSkills() {
        return skillsParaMelhorar;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidatura that = (Candidatura) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
