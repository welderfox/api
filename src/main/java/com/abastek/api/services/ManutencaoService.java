package com.abastek.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abastek.api.dtos.ManutencoesDTO;
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
}
