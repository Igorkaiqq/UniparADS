package org.example.pdvapi.dto;

public record ItemVendaDTO(int quantidade, Double valorUnitario, Double valorTotal, Long vendaId, Long produtoId) {
}
