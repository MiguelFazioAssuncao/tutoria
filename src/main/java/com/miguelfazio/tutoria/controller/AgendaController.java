package com.miguelfazio.tutoria.controller;

import com.miguelfazio.tutoria.DTO.CreateAgendaDTO;
import com.miguelfazio.tutoria.DTO.UpdateAgendaDTO;
import com.miguelfazio.tutoria.database.entity.Agenda;
import com.miguelfazio.tutoria.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody CreateAgendaDTO createAgendaDTO) {
        var agendaId = agendaService.createAgenda(createAgendaDTO);
        return ResponseEntity.created(URI.create("/v1/agendas/" + agendaId)).build();
    }

    @GetMapping("/{agendaId}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable("agendaId") String agendaId) {
        var agenda = agendaService.getAgendaById(agendaId);
        return agenda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> listAgendas() {
        var agendas =  agendaService.listAgendas();
        return ResponseEntity.ok(agendas);
    }

    @PutMapping("/{agendaId}")
    public ResponseEntity<Void> updateAgendaById(@PathVariable("agendaId") String agendaId, @RequestBody UpdateAgendaDTO updateAgendaDTO) {
        agendaService.updateAgendaByid(agendaId, updateAgendaDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{agendaId}")
    public ResponseEntity<Void> deleteByid(@PathVariable("agendaId") String agendaId) {
        agendaService.deleteById(agendaId);
        return ResponseEntity.noContent().build();
    }

}
