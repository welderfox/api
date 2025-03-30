package com.abastek.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abastek.api.models.EquipamentosModel;

public interface EquipamentoRepository extends JpaRepository<EquipamentosModel, UUID> {
    // Query para obter o último código de equipamento
    EquipamentosModel findFirstByOrderByCodigoDesc();
}