package com.abastek.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abastek.api.dtos.ManutencoesDTO;
import com.abastek.api.models.EquipamentosModel;
import com.abastek.api.models.ManutencoesModel;
import com.abastek.api.repository.ManutencoesRepository;

@Service
public class ManutencaoService {
    private final ManutencoesRepository repository;
    private final EquipamentoService service;

    public ManutencaoService(ManutencoesRepository repository, EquipamentoService service){
        this.repository = repository;
        this.service = service;
    }

    public List<ManutencoesDTO> list(){
        List<ManutencoesModel> result = repository.findAll();

        return result.stream().map(x -> new ManutencoesDTO(x)).toList();
    }
    
    public ManutencoesDTO findById(UUID id){
        ManutencoesModel result = repository.findById(id).get();
        return new ManutencoesDTO(result);
    }

    public ManutencoesDTO update(UUID id,ManutencoesModel model){
        ManutencoesDTO dto = findById(id);
        model.setData(dto.getData());
        model.setDescricao(dto.getDescricao());

        ManutencoesModel manutencoesModel = repository.save(model);
        return new ManutencoesDTO(manutencoesModel);
    }

    public void deletar(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    /*private ManutencoesDTO toDTO(ManutencoesModel manutencao) {
        EquipamentosModel equipamento = service.findById(manutencao.getEquipamentoId());
        ManutencoesDTO dto = new ManutencoesDTO();
        dto.setId(manutencao.getId());
        dto.setDescricao(manutencao.getDescricao());
        dto.setData(manutencao.getData());
        dto.setEquipamentoId(equipamento.getId());
        dto.setEquipamentoNome(equipamento.getNome());
        return dto;
    }*/
}
