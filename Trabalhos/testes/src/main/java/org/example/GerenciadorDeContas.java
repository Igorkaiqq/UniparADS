package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorDeContas {

    private final List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Optional<Conta> buscarContaPorNumero(int numero) {
        return contas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst();
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(numeroContaOrigem)
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada."));

        Conta contaDestino = buscarContaPorNumero(numeroContaDestino)
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada."));

        if (contaOrigem.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

}
