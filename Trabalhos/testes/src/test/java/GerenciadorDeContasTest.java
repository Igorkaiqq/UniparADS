import org.example.Conta;
import org.example.GerenciadorDeContas;
import org.junit.Test;

import static org.junit.Assert.*;

public class GerenciadorDeContasTest {

    private final GerenciadorDeContas gerenciador = new GerenciadorDeContas();

    @Test
    public void testAdicionarConta_NewAccount_AddsSuccessfully() {
        Conta conta = new Conta(1, 1000, "Cliente 1");
        gerenciador.adicionarConta(conta);

        assertTrue(gerenciador.buscarContaPorNumero(1).isPresent());
    }

    @Test
    public void testBuscarContaPorNumero_ExistingAccount_ReturnsAccount() {
        Conta conta = new Conta(1, 1000, "Cliente 1");
        gerenciador.adicionarConta(conta);

        assertEquals(conta, gerenciador.buscarContaPorNumero(1).orElse(null));
    }

    @Test
    public void testTransferir_SufficientBalance_TransfersSuccessfully() {
        Conta conta1 = new Conta(1, 1000, "Cliente 1");
        Conta conta2 = new Conta(2, 500, "Cliente 2");
        gerenciador.adicionarConta(conta1);
        gerenciador.adicionarConta(conta2);

        gerenciador.transferir(1, 2, 200);

        assertEquals(800, conta1.getSaldo(), 0.0001);
        assertEquals(700, conta2.getSaldo(), 0.0001);
    }

    @Test
    public void testTransferir_InsufficientBalance_ThrowsIllegalStateException() {
        Conta conta1 = new Conta(1, 100, "Cliente 1");
        Conta conta2 = new Conta(2, 500, "Cliente 2");
        gerenciador.adicionarConta(conta1);
        gerenciador.adicionarConta(conta2);

        assertThrows(IllegalArgumentException.class, () -> gerenciador.transferir(1, 2, 200));
    }

    @Test
    public void testTransferir_NonExistingAccounts_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> gerenciador.transferir(1, 2, 100));
    }

}
