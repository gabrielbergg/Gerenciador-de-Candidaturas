package com.example.candidaturas.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseException implements Serializable {

    private LocalDateTime data;
    private String mensage;
    private String details;

    public ResponseException() {}

    public ResponseException(LocalDateTime data, String mensage, String details) {
        this.data = data;
        this.mensage = mensage;
        this.details = details;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
