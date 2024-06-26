package org.example.pdvapi.controllers;

import org.example.pdvapi.entity.ItemVendaEntity;
import org.example.pdvapi.entity.VendaEntity;
import org.example.pdvapi.interfaces.IItemVendaController;
import org.example.pdvapi.services.ItemVendaService;
import org.example.pdvapi.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemVendaController implements IItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;
    @Autowired
    private VendaService vendaService;

    @Override
    public ResponseEntity<ItemVendaEntity> insert (@RequestBody ItemVendaEntity itemVenda, UriComponentsBuilder uriBuilder ){

        VendaEntity venda = itemVenda.getVenda();
        vendaService.insert(venda);

        itemVendaService.insert(itemVenda);
        URI uri = uriBuilder.path("/itens-venda/{id}").buildAndExpand(itemVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(itemVenda);
    }

    @Override
    public ResponseEntity<ItemVendaEntity> update (@PathVariable Long id, @RequestBody ItemVendaEntity itemVenda){
        return ResponseEntity.ok(itemVendaService.update(itemVenda));
    }

    @Override
    public ResponseEntity<Void> delete (@PathVariable Long id){
        itemVendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ItemVendaEntity> findById (@PathVariable Long id){
        return ResponseEntity.ok(itemVendaService.findById(id));
    }

    @Override
    public ResponseEntity<List<ItemVendaEntity>> findAll (){
        return ResponseEntity.ok(itemVendaService.findAll());
    }

    @Override
    public ResponseEntity<Double> calcularItemVenda(Double preco, Integer quantidade) {
        Double total = preco * quantidade;
        return ResponseEntity.ok(total);
    }

}
