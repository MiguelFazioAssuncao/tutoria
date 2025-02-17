package com.miguelfazio.tutoria.controller;

import com.miguelfazio.tutoria.database.entity.Aluno;
import com.miguelfazio.tutoria.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody CreateAlunoDTO createAlunoDTO) {
        var alunoId = alunoService.createAluno(createAlunoDTO);
        return ResponseEntity.created(URI.create("/v1/alunos/" + alunoId)).build();
   }

    @GetMapping("/{alunoId}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable("alunoId") String alunoId) {
        var aluno = alunoService.getAlunoById(alunoId);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listAlunos() {
        var alunos = alunoService.listAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Void> updateAlunoById(@PathVariable("alunoId") String alunoId, @RequestBody UpdateAlunoDTO updateAlunoDTO) {
        alunoService.updateAlunoById(alunoId, updateAlunoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("alunoId") String alunoId) {
        alunoService.deleteById(alunoId);
        return ResponseEntity.noContent().build();
    }
}
