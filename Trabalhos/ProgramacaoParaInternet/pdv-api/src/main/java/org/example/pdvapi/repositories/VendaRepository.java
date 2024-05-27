package org.example.pdvapi.repositories;

import org.example.pdvapi.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long>{
}
