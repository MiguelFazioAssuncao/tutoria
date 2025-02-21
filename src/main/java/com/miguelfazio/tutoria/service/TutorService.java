package com.miguelfazio.tutoria.service;

import com.miguelfazio.tutoria.DTO.CreateTutorDTO;
import com.miguelfazio.tutoria.DTO.UpdateAlunoDTO;
import com.miguelfazio.tutoria.DTO.UpdateTutorDTO;
import com.miguelfazio.tutoria.database.entity.Tutor;
import com.miguelfazio.tutoria.database.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public UUID createTutor(CreateTutorDTO createTutorDTO) {
        if (createTutorDTO.especialidade() == null || createTutorDTO.especialidade().isEmpty()) {
            throw new IllegalArgumentException("Especialidade não pode ser nula ou vazia");
        }

        var entity = new Tutor(createTutorDTO.nome(), createTutorDTO.especialidade());
        var tutorSaved = tutorRepository.save(entity);

        return tutorSaved.getId();
    }

    public Optional<Tutor> getTutorById(String tutorId) {
        return tutorRepository.findById(UUID.fromString(tutorId));
    }

    public List<Tutor> listTutores() {
        return tutorRepository.findAll();
    }

    public void updateTutorById(String tutorId, UpdateTutorDTO      updateTutorDTO) {
        var id = UUID.fromString(tutorId);
        var tutorExists = tutorRepository.findById(id);

        if (tutorExists.isPresent()) {
            var tutor = tutorExists.get();

            if (updateTutorDTO.nome() != null) {
                tutor.setNome(updateTutorDTO.nome());
            }

            if (updateTutorDTO.especialidade() != null) {
                tutor.setEspecialidade(updateTutorDTO.especialidade());
            }


            tutorRepository.save(tutor);
        }
    }

    public void deleteById(String tutorId) {
        var id = UUID.fromString(tutorId);
        var tutorExists = tutorRepository.existsById(id);

        if (tutorExists) {
            tutorRepository.deleteById(id);
        }
    }
}
