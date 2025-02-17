package com.miguelfazio.tutoria.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateAlunoDTO(@JsonProperty("nome") String nome) {
}
