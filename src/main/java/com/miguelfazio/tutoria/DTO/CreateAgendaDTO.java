package com.miguelfazio.tutoria.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record CreateAgendaDTO(
        @JsonProperty("alunoId") String alunoId,
        @JsonProperty("tutorId") String tutorId,
        @JsonProperty("data") Date data,
        @JsonProperty("status") String status,
        @JsonProperty("tema") String tema,
        @JsonProperty("descricao") String descricao
) {}
