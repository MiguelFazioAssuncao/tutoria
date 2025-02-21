package com.miguelfazio.tutoria.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_agendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false, length = 500)
    private String descricao;

    public Agenda(Aluno aluno, Tutor tutor, Date data, String status, String tema, String descricao) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.data = data;
        this.status = status;
        this.tema = tema;
        this.descricao = descricao;
    }
}
