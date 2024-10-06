package org.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {

    public final List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido buscarPedidoPorId(int idPedido) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == idPedido)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));
    }

    public double calcularValorTotal(int idPedido) {
        Pedido pedido = pedidos.stream()
                .filter(p -> p.getId() == idPedido)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));

        return pedido.getItens().stream()
                .mapToDouble(item -> item.getPreco() * item.getQuantidade())
                .sum();
    }

    public List<Pedido> listarPedidosPorCliente(String nomeCliente) {
        return pedidos.stream()
                .filter(pedido -> pedido.getNome().equals(nomeCliente))
                .toList();
    }


}
