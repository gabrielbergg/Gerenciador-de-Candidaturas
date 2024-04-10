package com.example.candidaturas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MelhorarSkills")
public class MelhorarSkills  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String melhorias;

    public MelhorarSkills() {}

    public MelhorarSkills(Long id, String melhorias) {
        this.id = id;
        this.melhorias = melhorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMelhorias() {
        return melhorias;
    }

    public void setMelhorias(String melhorias) {
        this.melhorias = melhorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelhorarSkills that = (MelhorarSkills) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
