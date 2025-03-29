package com.abastek.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abastek.api.models.EquipamentosModel;
import com.abastek.api.repository.EquipamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository){
        this.repository = repository;
    }

    public List<EquipamentosModel> list(){
        return repository.findAll();
    }

    public EquipamentosModel findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado..."));
    }
    
    @Transactional
    public EquipamentosModel insert(EquipamentosModel equipamentos){
      return  repository.save(equipamentos);
    }

    public EquipamentosModel update(UUID id, EquipamentosModel equipamentos){
        EquipamentosModel exist = findById(id);
        exist.setNome(equipamentos.getNome());
        exist.setSetor(equipamentos.getSetor());

        return repository.save(exist);
    }

    public void deletar(UUID id) {
        findById(id);
        repository.deleteById(id);
    }
}
