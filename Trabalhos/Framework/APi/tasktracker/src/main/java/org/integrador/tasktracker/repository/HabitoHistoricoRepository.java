package org.integrador.tasktracker.repository;

import org.integrador.tasktracker.entity.HabitoHistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitoHistoricoRepository extends JpaRepository<HabitoHistoricoEntity, Long> {
    List<HabitoHistoricoEntity> findByHabitoId(Long habitoId);
}
