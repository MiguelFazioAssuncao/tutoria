package com.miguelfazio.tutoria.controller;

import com.miguelfazio.tutoria.DTO.CreateTutorDTO;
import com.miguelfazio.tutoria.DTO.UpdateTutorDTO;
import com.miguelfazio.tutoria.database.entity.Tutor;
import com.miguelfazio.tutoria.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody CreateTutorDTO createTutorDTO) {
        UUID tutorId = tutorService.createTutor(createTutorDTO);
        return ResponseEntity.created(URI.create("/v1/tutores/" + tutorId)).build();
    }

   @GetMapping("/{tutorId}")
   public ResponseEntity<Tutor> getTutorById(@PathVariable("tutorId") String tutorId) {
        var tutor =  tutorService.getTutorById(tutorId);
       return tutor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @GetMapping
    public ResponseEntity<List<Tutor>> listTutores() {
        var tutores = tutorService.listTutores();
        return ResponseEntity.ok(tutores);
   }

   @PutMapping("/{tutorId}")
   public ResponseEntity<Void> updateTutorById(@PathVariable("tutorId") String tutorId, @RequestBody UpdateTutorDTO updateTutorDTO) {
        tutorService.updateTutorById(tutorId, updateTutorDTO);
        return ResponseEntity.noContent().build();
   }

   @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> deleteById(@PathVariable("tutorId") String tutorId) {
        tutorService.deleteById(tutorId);
        return ResponseEntity.noContent().build();
    }
}
