package com.abastek.api.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abastek.api.dtos.ManutencoesDTO;
import com.abastek.api.models.EquipamentosModel;
import com.abastek.api.models.ManutencoesModel;
import com.abastek.api.repository.EquipamentoRepository;
import com.abastek.api.repository.ManutencoesRepository;

@Service
public class ManutencaoService {
    private final ManutencoesRepository repository;
    private final EquipamentoRepository equipamentoRepository;

    public ManutencaoService(ManutencoesRepository repository,
            EquipamentoRepository equipamentoRepository) {
        this.repository = repository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<ManutencoesDTO> list() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ManutencoesDTO findById(UUID id) {
        ManutencoesModel result = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));
        return toDTO(result);
    }

    public ManutencoesDTO insert(ManutencoesModel manutencao) {
        // Busca o equipamento por ID antes de salvar
        UUID equipamentoId = manutencao.getEquipamento().getId();
        EquipamentosModel equipamento = equipamentoRepository.findById(equipamentoId)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        // Verifica se a data da manutenção não seja anterior à data de fabricação do
        // equipamento associado.
        if (manutencao.getData().isBefore(equipamento.getDataDeFabricacao())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A data da manutenção não pode ser anterior à data de fabricação do equipamento.");
        }

        manutencao.setEquipamento(equipamento);

        ManutencoesModel salva = repository.save(manutencao);
        return toDTO(salva);
    }

    public ManutencoesDTO update(UUID id, ManutencoesModel manutencaoAtualizada) {
        // Busca a manutenção existente
        ManutencoesModel manutencaoExistente = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manutenção não encontrada"));
    
        // Atualiza apenas os campos permitidos
        manutencaoExistente.setDescricao(manutencaoAtualizada.getDescricao());
        manutencaoExistente.setData(manutencaoAtualizada.getData());
    
        // Valida se a data da manutenção é válida (não pode ser anterior à data de fabricação)
        EquipamentosModel equipamento = manutencaoExistente.getEquipamento();
        if (manutencaoAtualizada.getData().isBefore(equipamento.getDataDeFabricacao())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A data da manutenção não pode ser anterior à data de fabricação do equipamento.");
        }
    
        //Atualização no banco de dados
        ManutencoesModel manutencaoSalva = repository.save(manutencaoExistente);
    
        return toDTO(manutencaoSalva);
    }  
    
    public void deletar(UUID id) {
        findById(id);
        repository.deleteById(id);
    }
    
    private ManutencoesDTO toDTO(ManutencoesModel manutencao) {
        EquipamentosModel equipamento = manutencao.getEquipamento();
        ManutencoesDTO dto = new ManutencoesDTO();
        dto.setId(manutencao.getId());
        dto.setDescricao(manutencao.getDescricao());
        dto.setData(manutencao.getData());
        dto.setEquipamentoId(equipamento.getId());
        dto.setEquipamentoNome(equipamento.getNome());
        dto.setDataDeFabricacao(equipamento.getDataDeFabricacao());
        dto.setCodigo(equipamento.getCodigo());
        return dto;
    }
}
