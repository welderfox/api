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

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<EquipamentosModel> list() {
        return repository.findAll();
    }

    public EquipamentosModel findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado..."));
    }

    /*
     * @Transactional
     * public EquipamentosModel insert(EquipamentosModel equipamentos){
     * return repository.save(equipamentos);
     * }
     */

    @Transactional
    public EquipamentosModel insert(EquipamentosModel equipamentos) {
        // Gera o código único
        String codigo = generateCodigoUnico();
        equipamentos.setCodigo(codigo);

        // Salva o equipamento
        return repository.save(equipamentos);
    }

    public EquipamentosModel update(UUID id, EquipamentosModel equipamentos) {
        EquipamentosModel exist = findById(id);
        exist.setNome(equipamentos.getNome());
        exist.setSetor(equipamentos.getSetor());

        return repository.save(exist);
    }

    public void deletar(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    /**
     * Gera Código unico para equipamento.
     *
     * @return Retorna codigo unico para equipamento, (texto único, ex.: "EQP-001").
     */
    private String generateCodigoUnico() {
        // Obtém o último equipamento registrado (ordem decrescente pelo código)
        EquipamentosModel lastEquipamento = repository.findFirstByOrderByCodigoDesc();

        // Se não houver registros, começa de "EQP-001"
        String lastCodigo = lastEquipamento == null ? "EQP-000" : lastEquipamento.getCodigo();

        // Extrai o número sequencial do código, por exemplo: "001"
        int sequencial = Integer.parseInt(lastCodigo.replace("EQP-", "")) + 1;

        // Formata o código com prefixo "EQP-" e número sequencial
        return "EQP-" + String.format("%03d", sequencial);
    }
}
