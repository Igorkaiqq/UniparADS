package org.example.pdvapi.services;

import org.example.pdvapi.entity.ClienteEntity;
import org.example.pdvapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity insert(ClienteEntity cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public ClienteEntity update(ClienteEntity cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

}
