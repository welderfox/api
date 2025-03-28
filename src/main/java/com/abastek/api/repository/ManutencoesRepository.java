package com.abastek.api.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abastek.api.models.ManutencoesModel;

public interface ManutencoesRepository extends JpaRepository<ManutencoesModel,UUID>{

}
