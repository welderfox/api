package com.abastek.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        public ResponseEntity<List<EquipamentosModel>> listar() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<EquipamentosModel> salvar(@RequestBody EquipamentosModel equipamento) {
        return ResponseEntity.ok(service.insert(equipamento));
    }
}