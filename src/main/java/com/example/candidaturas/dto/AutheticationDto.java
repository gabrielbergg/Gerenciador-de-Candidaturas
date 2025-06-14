package com.example.candidaturas.dto;

import com.example.candidaturas.enums.Roles;

public record AutheticationDto(Long userId, String name, String login, Roles roles, String password) {
}
