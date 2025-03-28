package com.abastek.api.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TB_EQUIPAMENTOS")
public class Equipamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String setor;
  
    public Equipamentos(){}
    
    public Equipamentos(String nome, String setor) {
        this.nome = nome;
        this.setor = setor;
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
}
