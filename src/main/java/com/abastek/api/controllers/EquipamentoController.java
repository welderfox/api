package com.abastek.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abastek.api.models.EquipamentosModel;
import com.abastek.api.services.EquipamentoService;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

private final EquipamentoService service;

        public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EquipamentosModel>> getAll() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentosModel> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EquipamentosModel> insert(@RequestBody EquipamentosModel equipamento) {
        return ResponseEntity.ok(service.insert(equipamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentosModel> updat(@PathVariable UUID id, @RequestBody EquipamentosModel equipamento) {
        return ResponseEntity.ok(service.update(id, equipamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delet(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}