package org.example;

import java.util.Collections;
import java.util.List;

public class EstatisticasDeLista {

    public double calcularMedia(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
        }

        double soma = 0;
        for (Double numero : numeros) {
            if (numero == null) {
                throw new IllegalArgumentException("A lista contém valores nulos.");
            }
            soma += numero;
        }
        return soma / numeros.size();
    }

    public double calcularMediana(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
        }
        
        for (Double numero : numeros) {
            if (numero == null) {
                throw new IllegalArgumentException("A lista contém valores nulos.");
            }
        }

        Collections.sort(numeros);

        int tamanho = numeros.size();
        if (tamanho % 2 == 0) {
            return (numeros.get(tamanho / 2 - 1) + numeros.get(tamanho / 2)) / 2.0;
        } else {
            return numeros.get(tamanho / 2);
        }
    }

    public double calcularDesvioPadrao(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
        }

        double media = calcularMedia(numeros);
        double somaQuadrados = 0;

        for (Double numero : numeros) {
            if (numero == null) {
                throw new IllegalArgumentException("A lista contém valores nulos.");
            }
            somaQuadrados += Math.pow(numero - media, 2);
        }

        return Math.sqrt(somaQuadrados / numeros.size());
    }
}
