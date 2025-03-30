package com.abastek.api.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "TB_MANUTENCOES")
public class ManutencoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentosModel equipamento;

    public ManutencoesModel() {
    }

    public ManutencoesModel(@NonNull String descricao, @NonNull LocalDate data,
            @NonNull EquipamentosModel equipamento) {
        this.descricao = descricao;
        this.data = data;
        this.equipamento = equipamento;
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

    public EquipamentosModel getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentosModel equipamento) {
        this.equipamento = equipamento;
    }
}
