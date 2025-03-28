package com.abastek.api.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TB_MANUTENCOES")
public class ManutencoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    private LocalDate data;
    private UUID equipamentoId;

    public ManutencoesModel(){}

    public ManutencoesModel(String descricao, LocalDate data, UUID equipamentoId) {
        this.descricao = descricao;
        this.data = data;
        this.equipamentoId = equipamentoId;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public UUID getEquipamentoId() {
        return equipamentoId;
    }
    public void setEquipamentoId(UUID equipamentoId) {
        this.equipamentoId = equipamentoId;
    }
}
