package com.miguelfazio.tutoria.service;

import com.miguelfazio.tutoria.DTO.CreateAgendaDTO;
import com.miguelfazio.tutoria.DTO.UpdateAgendaDTO;
import com.miguelfazio.tutoria.database.entity.Agenda;
import com.miguelfazio.tutoria.database.repository.AgendaRepository;
import com.miguelfazio.tutoria.database.repository.AlunoRepository;
import com.miguelfazio.tutoria.database.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final TutorRepository tutorRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository, TutorRepository tutorRepository, AlunoRepository alunoRepository) {
        this.agendaRepository = agendaRepository;
        this.tutorRepository = tutorRepository;
        this.alunoRepository = alunoRepository;
    }

    public UUID createAgenda(CreateAgendaDTO createAgendaDTO) {
        if (createAgendaDTO.alunoId() == null || createAgendaDTO.alunoId().isEmpty()) {
            throw new IllegalArgumentException("Aluno ID is required");
        }
        if (createAgendaDTO.tutorId() == null || createAgendaDTO.tutorId().isEmpty()) {
            throw new IllegalArgumentException("Tutor ID is required");
        }
        if (createAgendaDTO.tema() == null || createAgendaDTO.tema().isEmpty()) {
            throw new IllegalArgumentException("Tema is required");
        }
        if (createAgendaDTO.descricao() == null || createAgendaDTO.descricao().isEmpty()) {
            throw new IllegalArgumentException("Descricao is required");
        }

        var aluno = alunoRepository.findById(UUID.fromString(createAgendaDTO.alunoId()))
                .orElseThrow(() -> new IllegalArgumentException("Aluno not found"));

        var tutor = tutorRepository.findById(UUID.fromString(createAgendaDTO.tutorId()))
                .orElseThrow(() -> new IllegalArgumentException("Tutor not found"));

        var agenda = new Agenda(
                aluno,
                tutor,
                createAgendaDTO.data(),
                createAgendaDTO.status(),
                createAgendaDTO.tema(),
                createAgendaDTO.descricao()
        );

        var agendaSaved = agendaRepository.save(agenda);
        return agendaSaved.getId();
    }

    public Optional<Agenda> getAgendaById(String agendaId) {
        return agendaRepository.findById(UUID.fromString(agendaId));
    }

    public List<Agenda> listAgendas() {
        return agendaRepository.findAll();
    }

    public void updateAgendaByid(String agendaId, UpdateAgendaDTO updateAgendaDTO) {
        var id = UUID.fromString(agendaId);
        var agendaExists = agendaRepository.findById(id);

        if (agendaExists.isPresent()) {
            var agenda = agendaExists.get();

            if (updateAgendaDTO.alunoId() != null) {
                var aluno = alunoRepository.findById(UUID.fromString(updateAgendaDTO.alunoId()))
                        .orElseThrow(() -> new IllegalArgumentException("Aluno not found"));
                agenda.setAluno(aluno);
            }

            if (updateAgendaDTO.tutorId() != null) {
                var tutor = tutorRepository.findById(UUID.fromString(updateAgendaDTO.tutorId()))
                        .orElseThrow(() -> new IllegalArgumentException("Tutor not found"));
                agenda.setTutor(tutor);
            }

            if (updateAgendaDTO.data() != null) {
                agenda.setData(updateAgendaDTO.data());
            }

            if (updateAgendaDTO.status() != null) {
                agenda.setStatus(updateAgendaDTO.status());
            }

            if (updateAgendaDTO.tema() != null) {
                agenda.setTema(updateAgendaDTO.tema());
            }

            if (updateAgendaDTO.descricao() != null) {
                agenda.setDescricao(updateAgendaDTO.descricao());
            }

            var agendaSaved = agendaRepository.save(agenda);

        }
    }

    public void deleteById(String agendaId) {
        var id = UUID.fromString(agendaId);
        var agendaExists = agendaRepository.existsById(id);

        if (agendaExists) {
            agendaRepository.deleteById(id);
        }
    }
}
