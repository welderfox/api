package com.abastek.api.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TB_EQUIPAMENTOS")
public class EquipamentosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String setor;
    private LocalDate dataDeFabricacao;
  
    public EquipamentosModel(){}
    
    public EquipamentosModel(String nome, String setor, LocalDate dataDeFabricacao) {
        this.nome = nome;
        this.setor = setor;
        this.dataDeFabricacao = dataDeFabricacao;
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
