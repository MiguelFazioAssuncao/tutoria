package com.miguelfazio.tutoria.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_alunos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public Aluno(String nome) {
        this.nome = nome;
    }
}
