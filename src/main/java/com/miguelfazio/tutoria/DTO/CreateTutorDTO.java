package com.miguelfazio.tutoria.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTutorDTO(@JsonProperty("nome") String nome, @JsonProperty("especialidade") String especialidade) {
    @JsonCreator
    public CreateTutorDTO {
    }
}
