package com.abastek.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abastek.api.models.EquipamentosModel;
import com.abastek.api.repository.EquipamentoRepository;
import com.abastek.api.services.EquipamentoService;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

private final EquipamentoService service;

        private final EquipamentoRepository repository;

        public EquipamentoController(EquipamentoService service, EquipamentoRepository repository) {
        this.service = service;
        this.repository = repository;
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
    public ResponseEntity<EquipamentosModel> update(@PathVariable UUID id, @RequestBody EquipamentosModel equipamento) {
        return ResponseEntity.ok(service.update(id, equipamento));
    }

    public ResponseEntity<EquipamentosModel> updateEquipamento(@PathVariable UUID id, @RequestBody EquipamentosModel equipamento) {
        // Impede que o código seja alterado
        EquipamentosModel existingEquipamento = repository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
        equipamento.setCodigo(existingEquipamento.getCodigo()); // Mantém o código original
        equipamento.setId(id);

        EquipamentosModel updatedEquipamento = service.insert(equipamento);
        return ResponseEntity.ok(updatedEquipamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delet(id);
        return ResponseEntity.noContent().build();
    }
}