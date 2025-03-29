package com.abastek.api.dtos;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.abastek.api.models.EquipamentosModel;

public class EquipamentosDTO {

    private UUID id;
    private String nome;
    private String setor;
    private LocalDate dataDeFabricacao;

    public EquipamentosDTO(EquipamentosModel model) {
        BeanUtils.copyProperties(model, this);
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }
    
}
