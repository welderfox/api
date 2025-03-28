package com.abastek.api.dtos;

import java.util.UUID;
import java.time.LocalDate;

public class ManutencoesDTO {

    private UUID id;
    private String descricao;
    private LocalDate data;
    private Long equipamentoId;
    private String equipamentoNome; //TODO: para relatório

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
    public Long getEquipamentoId() {
        return equipamentoId;
    }
    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }
    public String getEquipamentoNome() {
        return equipamentoNome;
    }
    public void setEquipamentoNome(String equipamentoNome) {
        this.equipamentoNome = equipamentoNome;
    }
}
