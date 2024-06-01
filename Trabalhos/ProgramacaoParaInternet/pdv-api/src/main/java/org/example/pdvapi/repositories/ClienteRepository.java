package org.example.pdvapi.repositories;

import org.example.pdvapi.dto.ClienteDTO;
import org.example.pdvapi.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteDTO, Long> {

    @Query
    public List<ClienteDTO> findByNomeContaining(String nome);

}
