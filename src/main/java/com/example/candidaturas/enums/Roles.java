package com.example.candidaturas.enums;

public enum Roles {

    USER("Usuário"),
    VISITOR("Visitante");

    private String roles;

    Roles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
