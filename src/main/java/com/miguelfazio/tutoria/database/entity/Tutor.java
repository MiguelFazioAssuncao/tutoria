package com.miguelfazio.tutoria.database.entity;

import lombok.Data;

@Data
public class Tutor {
    private String nome;
    private String especialidade;

    public Tutor(){
    }

    public Tutor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
}
