package org.example.pdvapi.dto;

import java.sql.Date;

public record VendaDTO(Date data, Long clienteId, Double valorTotal, String observacoes) {
}
