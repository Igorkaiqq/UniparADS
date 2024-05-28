package org.example.pdvapi.repositories;

import org.example.pdvapi.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    public List<ClienteEntity> findByNomeContaining(String nome);

}
