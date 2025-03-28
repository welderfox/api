package com.abastek.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abastek.api.models.Equipamentos;

public interface EquipamentoRepository extends JpaRepository<Equipamentos,UUID>{

}