package com.abastek.api.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abastek.api.models.Manutencoes;

public interface ManutencoesRepository extends JpaRepository<Manutencoes,UUID>{

}
