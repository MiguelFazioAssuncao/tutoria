package com.miguelfazio.tutoria.service;

import com.miguelfazio.tutoria.DTO.CreateAlunoDTO;
import com.miguelfazio.tutoria.DTO.UpdateAlunoDTO;
import com.miguelfazio.tutoria.database.entity.Aluno;
import com.miguelfazio.tutoria.database.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public UUID createAluno(CreateAlunoDTO createAlunoDTO) {
        var entity = new Aluno(createAlunoDTO.nome());
        var userSaved = alunoRepository.save(entity);

        return userSaved.getId();
    }

    public Optional<Aluno> getAlunoById(String alunoId) {
        return alunoRepository.findById(UUID.fromString(alunoId));
    }

    public List<Aluno> listAlunos() {
        return alunoRepository.findAll();
    }

    public void updateAlunoById(String alunoId, UpdateAlunoDTO updateAlunoDTO) {
        var id = UUID.fromString(alunoId);
        var alunoExists = alunoRepository.findById(id);

        if (alunoExists.isPresent()) {
            var aluno = alunoExists.get();

            if (updateAlunoDTO.nome() != null) {
                aluno.setNome(updateAlunoDTO.nome());
            }

            alunoRepository.save(aluno);
        }
    }

    public void deleteById(String alunoId) {
        var id = UUID.fromString(alunoId);
        var alunoExists = alunoRepository.existsById(id);

        if (alunoExists) {
            alunoRepository.deleteById(id);
        }
    }

}
