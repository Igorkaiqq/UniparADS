package org.example.pdvapi.repositories;

import org.example.pdvapi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query
    UserDetails findByLogin(String usuario);

    @Query
    UserDetails findByEmail(String email);

}
