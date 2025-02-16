package com.miguelfazio.tutoria.database.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Agenda {
    private Aluno aluno;
    private Tutor tutor;
    private Date data;
    private String status;
    private String tema;
    private String descricao;

    public Agenda(){
    }

    public Agenda(Aluno aluno, Tutor tutor, Date data, String status, String tema, String descricao) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.data = data;
        this.status = status;
        this.tema = tema;
        this.descricao = descricao;
    }
}
