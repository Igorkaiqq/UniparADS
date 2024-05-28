package org.example.pdvapi.repositories;

import org.example.pdvapi.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query
    public List<ProdutoEntity> findByDescricaoContaining(String descricao);

}
