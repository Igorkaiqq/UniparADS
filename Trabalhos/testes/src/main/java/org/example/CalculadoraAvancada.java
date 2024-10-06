package org.example;

public class CalculadoraAvancada {

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double raizQuadrada(double numero) {
        if (numero < 0) throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        return Math.sqrt(numero);
    }

    public double logaritmoNatural(double numero) {
        if (numero <= 0) throw new IllegalArgumentException("Não é possível calcular o logaritmo natural de um número menor ou igual a zero.");
        return Math.log(numero);
    }

}
