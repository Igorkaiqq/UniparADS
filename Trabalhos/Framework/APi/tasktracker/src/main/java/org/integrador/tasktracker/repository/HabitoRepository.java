package org.integrador.tasktracker.repository;

import org.integrador.tasktracker.entity.HabitoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitoRepository extends JpaRepository<HabitoEntity, Long> {
    List<HabitoEntity> findByUsuarioId(Long usuarioId);
}
