package com.example.candidaturas.dto;

import com.example.candidaturas.enums.Roles;
import com.example.candidaturas.model.Candidatura;

import java.util.List;

public record UserDto(String name, Roles role, List<Candidatura> candidatura) {
}
