package com.miguelfazio.tutoria.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_materiais")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private Agenda agenda;

    @Column(columnDefinition = "VARCHAR(80)",nullable = false)
    private String descricao;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String caminhoArquivo;

    public Material(Agenda agenda, String descricao, String caminhoArquivo) {
        this.agenda = agenda;
        this.descricao = descricao;
        this.caminhoArquivo = caminhoArquivo;
    }
}
