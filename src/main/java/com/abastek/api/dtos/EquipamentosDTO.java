package com.abastek.api.dtos;

import java.util.UUID;

public class EquipamentosDTO {

    private UUID id;
    private String nome;
    private String setor;

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
}
