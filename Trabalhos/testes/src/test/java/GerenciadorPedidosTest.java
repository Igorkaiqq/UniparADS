import org.example.GerenciadorPedidos;
import org.example.ItemPedido;
import org.example.Pedido;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GerenciadorPedidosTest {

    private final GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    @Test
    public void testAdicionarPedido_NewOrder_AddsSuccessfully() {
        Pedido pedido = new Pedido(1, "Cliente 1", Arrays.asList(
                new ItemPedido("Produto 1", 10.0, 2),
                new ItemPedido("Produto 2", 20.0, 1)
        ));
        gerenciador.adicionarPedido(pedido);

        List<Pedido> pedidos = gerenciador.listarPedidosPorCliente("Cliente 1");
        assertEquals(1, pedidos.size());
    }

    @Test
    public void testCalcularValorTotal_OrderWithItems_ReturnsCorrectTotal() {
        Pedido pedido = new Pedido(1, "Cliente 1", Arrays.asList(
                new ItemPedido("Produto 1", 10.0, 2),
                new ItemPedido("Produto 2", 20.0, 1)
        ));
        gerenciador.adicionarPedido(pedido);

        double total = gerenciador.calcularValorTotal(1);
        assertEquals(40.0, total, 0.0001);
    }

    @Test
    public void testListarPedidosPorCliente_ExistingClient_ReturnsOrders() {
        Pedido pedido1 = new Pedido(1, "Cliente 1", Arrays.asList(
                new ItemPedido("Produto 1", 10.0, 2)
        ));
        Pedido pedido2 = new Pedido(2, "Cliente 1", Arrays.asList(
                new ItemPedido("Produto 2", 20.0, 1)
        ));
        Pedido pedido3 = new Pedido(3, "Cliente 2", Arrays.asList(
                new ItemPedido("Produto 3", 30.0, 1)
        ));
        gerenciador.adicionarPedido(pedido1);
        gerenciador.adicionarPedido(pedido2);
        gerenciador.adicionarPedido(pedido3);

        List<Pedido> pedidosCliente1 = gerenciador.listarPedidosPorCliente("Cliente 1");
        assertEquals(2, pedidosCliente1.size());
    }

    @Test
    public void testCalcularValorTotal_NonExistingOrder_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> gerenciador.calcularValorTotal(99));
    }

}
