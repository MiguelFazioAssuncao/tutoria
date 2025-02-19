package com.miguelfazio.tutoria.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateAlunoDTO(@JsonProperty("nome") String nome) {

}
