package com.abastek.api.dtos;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.abastek.api.models.ManutencoesModel;

import java.time.LocalDate;

public class ManutencoesDTO {

    private UUID id;
    private String descricao;
    private LocalDate data;
    private UUID equipamentoId;
    private String equipamentoNome; //TODO: para relatório

    public ManutencoesDTO(){}

    public ManutencoesDTO(ManutencoesModel model){
        BeanUtils.copyProperties(model, this);
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
    public String getEquipamentoNome() {
        return equipamentoNome;
    }
    public void setEquipamentoNome(String equipamentoNome) {
        this.equipamentoNome = equipamentoNome;
    }
}
