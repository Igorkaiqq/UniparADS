package org.example.pdvapi.core.openapi;

import org.example.pdvapi.entity.ClienteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface ClienteControllerOpenApi {

    ResponseEntity<ClienteEntity> insert(@RequestBody ClienteEntity cliente, UriComponentsBuilder uriBuilder);

    ResponseEntity<ClienteEntity> update(@PathVariable Long id, @RequestBody ClienteEntity cliente);

    ResponseEntity<Void> delete(@PathVariable Long id);

    ResponseEntity<ClienteEntity> findById(@PathVariable Long id);

    ResponseEntity<List<ClienteEntity>> findAll();
    
}
