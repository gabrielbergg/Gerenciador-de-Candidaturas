package com.example.candidaturas.enums;


public enum StatusCandidatura {

        AGUARDANDO_RESPOSTA("aguardandoResposta"),
        SEM_RESPOSTA("semResposta"),
        RESPOSTA_POSITIVA("respostaPositiva"),
        RESPOSTA_NEGATIVA("respostaNegativa");

        private String status;

    StatusCandidatura(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
