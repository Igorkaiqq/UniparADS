package org.example.pdvapi.controllers;

import org.example.pdvapi.entity.VendaEntity;
import org.example.pdvapi.interfaces.IVendaController;
import org.example.pdvapi.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController implements IVendaController {

    @Autowired
    private VendaService vendaService;

    @Override
    public ResponseEntity<VendaEntity> insert(@RequestBody VendaEntity venda, UriComponentsBuilder uriBuilder) {
        vendaService.insert(venda);
        URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @Override
    public ResponseEntity<VendaEntity> update(@PathVariable Long id, @RequestBody VendaEntity venda) {
        return ResponseEntity.ok(vendaService.update(venda));
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<VendaEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @Override
    public ResponseEntity<List<VendaEntity>> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

}
