package com.miguelfazio.tutoria.controller;

import com.miguelfazio.tutoria.DTO.CreateMaterialDTO;
import com.miguelfazio.tutoria.DTO.UpdateMaterialDTO;
import com.miguelfazio.tutoria.database.entity.Material;
import com.miguelfazio.tutoria.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/materiais")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody CreateMaterialDTO createMaterialDTO) {
        var materialId = materialService.createMaterial(createMaterialDTO);
        return ResponseEntity.created(URI.create("/v1/materiais/" + materialId)).build();
    }


    @GetMapping("/{materialId}")
    public ResponseEntity<Material> getMaterialById(@PathVariable("materialId") String materialId) {
        var material = materialService.getMaterialById(materialId);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Material>> listMateriais() {
        var materiais = materialService.listMateriais();
        return ResponseEntity.ok(materiais);
    }

    @PutMapping("/{materialId}")
    public ResponseEntity<Void> updateMaterialById(@PathVariable("materialId") String materialId, @RequestBody UpdateMaterialDTO updateMaterialDTO) {
        materialService.alterById(materialId, updateMaterialDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{materialId}")
    public ResponseEntity<Void> deleteById(@PathVariable("materialId") String materialId) {
        materialService.deleteById(materialId);
        return ResponseEntity.noContent().build();
    }
}
