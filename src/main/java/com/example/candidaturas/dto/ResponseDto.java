package com.example.candidaturas.dto;

import com.example.candidaturas.enums.Roles;

public record ResponseDto(String login, Roles roles, String token) {
}
