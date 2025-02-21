package com.miguelfazio.tutoria.service;

import com.miguelfazio.tutoria.DTO.CreateMaterialDTO;
import com.miguelfazio.tutoria.DTO.UpdateMaterialDTO;
import com.miguelfazio.tutoria.database.entity.Agenda;
import com.miguelfazio.tutoria.database.entity.Material;
import com.miguelfazio.tutoria.database.repository.AgendaRepository;
import com.miguelfazio.tutoria.database.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final AgendaRepository agendaRepository;

    public MaterialService(MaterialRepository materialRepository, AgendaRepository agendaRepository) {
        this.materialRepository = materialRepository;
        this.agendaRepository = agendaRepository;
    }

    public UUID createMaterial(CreateMaterialDTO createMaterialDTO) {
        if (createMaterialDTO.agendaId() == null) {
            throw new IllegalArgumentException("Agenda ID is required");
        }

        Agenda agenda = agendaRepository.findById(UUID.fromString(createMaterialDTO.agendaId()))
                .orElseThrow(() -> new IllegalArgumentException("Agenda not found"));

        Material material = new Material(
                agenda,
                createMaterialDTO.descricao(),
                createMaterialDTO.caminhoArquivo()
        );

        Material materialSaved = materialRepository.save(material);
        return materialSaved.getId();
    }

    public Optional<Material> getMaterialById(String materialId) {
        return materialRepository.findById(UUID.fromString(materialId));
    }

    public List<Material> listMateriais() {
        return materialRepository.findAll();
    }

    public void alterById(String materialId, UpdateMaterialDTO updateMaterialDTO) {
        var id = UUID.fromString(materialId);
        var material = materialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Material not found"));

        if (updateMaterialDTO.descricao() != null) {
            material.setDescricao(updateMaterialDTO.descricao());
        }

        if (updateMaterialDTO.caminhoArquivo() != null) {
            material.setCaminhoArquivo(updateMaterialDTO.caminhoArquivo());
        }

        materialRepository.save(material);
    }


    public void deleteById(String materialId) {
        var id = UUID.fromString(materialId);
        var materialExists = materialRepository.existsById(id);

        if (materialExists) {
            materialRepository.deleteById(id);
        }
    }
}
