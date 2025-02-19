package com.miguelfazio.tutoria.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateTutorDTO( @JsonProperty("nome") String nome, @JsonProperty("especialidade") String especialidade) {
}
