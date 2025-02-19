package com.miguelfazio.tutoria.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateAlunoDTO(@JsonProperty("nome") String nome) {
    @JsonCreator
    public CreateAlunoDTO{
    }
}
