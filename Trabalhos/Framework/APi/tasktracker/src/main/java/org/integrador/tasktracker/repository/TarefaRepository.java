package org.integrador.tasktracker.repository;

import org.integrador.tasktracker.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
    List<TarefaEntity> findByUsuarioId(Long usuarioId);
}
