package com.miguelfazio.tutoria.database.entity;

import lombok.Data;

@Data
public class Material {
    private Agenda agenda;
    private String descricao;
    private String caminhoArquivo;

    public Material() {
    }

    public Material(Agenda agenda, String descricao, String caminhoArquivo) {
        this.agenda = agenda;
        this.descricao = descricao;
        this.caminhoArquivo = caminhoArquivo;
    }
}
