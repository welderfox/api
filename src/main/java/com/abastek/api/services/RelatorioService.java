package com.abastek.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abastek.api.dtos.RelatorioDTO;
import com.abastek.api.models.EquipamentosModel;

@Service
public class RelatorioService {

    private final EquipamentoService equipamentoService;
    private final ManutencaoService manutencaoService;

    public RelatorioService(EquipamentoService equipamentoService, ManutencaoService manutencaoService) {
        this.equipamentoService = equipamentoService;
        this.manutencaoService = manutencaoService;
    }

    /**
     * Gera dados para montar um relatorio.
     *
     * @return Uma lista com dados para relatorio.
     */
    public List<RelatorioDTO> gerarRelatorio() {
        return manutencaoService.list().stream().map(m -> {
            RelatorioDTO dto = new RelatorioDTO();
            EquipamentosModel eq = equipamentoService.findById(m.getEquipamentoId());
            dto.setEquipamentoNome(eq.getNome());
            dto.setSetor(eq.getSetor());
            dto.setDescricaoManutencao(m.getDescricao());
            dto.setDataManutencao(m.getData());
            dto.setCodigoEquipamento(eq.getCodigo());
            return dto;
        }).collect(Collectors.toList());
    }
}
