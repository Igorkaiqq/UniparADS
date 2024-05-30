package org.example.pdvapi.services;

import org.example.pdvapi.entity.ClienteEntity;
import org.example.pdvapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<ClienteEntity> insert(ClienteEntity cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    public ResponseEntity<ClienteEntity> update(Long id, ClienteEntity cliente) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        if (!clienteEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    public ResponseEntity<Void> delete(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        if (!clienteEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ClienteEntity> findById(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    public ResponseEntity<List<ClienteEntity>> findAll() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<List<ClienteEntity>> findByNomeContaining(String nome) {
        List<ClienteEntity> clientes = clienteRepository.findByNomeContaining(nome);
        if (clientes.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

}
