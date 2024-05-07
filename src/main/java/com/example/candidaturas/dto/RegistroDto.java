package com.example.candidaturas.dto;

import com.example.candidaturas.enums.Roles;

public record RegistroDto(String login, Roles roles, String password) {
}
