package com.abastek.api.dtos;

import java.time.LocalDate;

public class RelatorioDTO {
    private String equipamentoNome;
    private String setor;
    private String descricaoManutencao;
    private LocalDate dataManutencao;

    public RelatorioDTO() {}

    public String getEquipamentoNome() {
        return equipamentoNome;
    }
    public void setEquipamentoNome(String equipamentoNome) {
        this.equipamentoNome = equipamentoNome;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getDescricaoManutencao() {
        return descricaoManutencao;
    }
    public void setDescricaoManutencao(String descricaoManutencao) {
        this.descricaoManutencao = descricaoManutencao;
    }
    public LocalDate getDataManutencao() {
        return dataManutencao;
    }
    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }
}
