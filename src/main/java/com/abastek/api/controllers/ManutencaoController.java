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

import com.abastek.api.dtos.ManutencoesDTO;
import com.abastek.api.models.ManutencoesModel;
import com.abastek.api.services.ManutencaoService;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {
        private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ManutencoesDTO>> getAll() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencoesDTO> finById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ManutencoesDTO> insert(@RequestBody ManutencoesModel manutencao) {
        return ResponseEntity.ok(service.insert(manutencao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManutencoesDTO> Updat(@PathVariable UUID id, @RequestBody ManutencoesModel manutencao) {
        return ResponseEntity.ok(service.update(id, manutencao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
