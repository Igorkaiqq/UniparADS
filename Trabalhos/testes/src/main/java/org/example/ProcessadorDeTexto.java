package org.example;

public class ProcessadorDeTexto {

    public String inverterPalavras(String frase) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }

        String[] palavras = frase.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (int i = palavras.length - 1; i >= 0; i--) {
            resultado.append(palavras[i]).append(" ");
        }
        return resultado.toString().trim();
    }

    public String substituirPalavras(String frase, String palavraAntiga, String palavraNova) {
        if (frase == null || palavraAntiga == null || palavraAntiga.isEmpty()) {
            return frase;
        }
        return frase.replace(palavraAntiga, palavraNova);
    }

    public int contarOcorrenciasDePalavra(String frase, String palavra) {
        if (frase == null || frase.isEmpty() || palavra.isEmpty() || palavra == null) {
            return 0;
        }

        String[] partes = frase.split(palavra);
        return partes.length;

    }

}
