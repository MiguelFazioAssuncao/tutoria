package com.miguelfazio.tutoria.database.repository;

import com.miguelfazio.tutoria.database.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AgendaRepository extends JpaRepository<Agenda, UUID> {

    List<Agenda> findByAlunoIdOrderByDataAsc(UUID alunoId);

    List<Agenda> findByTutorIdOrderByDataAsc(UUID tutorId);

    List<Agenda> findByAlunoIdAndDataAfterOrderByDataAsc(UUID alunoId, LocalDateTime data);

    List<Agenda> findByTutorIdAndDataAfterOrderByDataAsc(UUID tutorId, LocalDateTime data);
}
