import org.example.EstatisticasDeLista;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class EstatisticasDeListaTest {

    EstatisticasDeLista estatisticas = new EstatisticasDeLista();

    @Test
    public void testarCalculoMedia() {
        List<Double> numeros = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0);
        assertEquals(30.0, estatisticas.calcularMedia(numeros), 0.001);
    }

    @Test
    public void testarCalculoMedianaTamanhoImpar() {
        List<Double> numeros = Arrays.asList(1.0, 3.0, 5.0, 7.0, 9.0);
        assertEquals(5.0, estatisticas.calcularMediana(numeros), 0.001);
    }

    @Test
    public void testarCalculoMedianaTamanhoPar() {
        List<Double> numeros = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        assertEquals(2.5, estatisticas.calcularMediana(numeros), 0.001);
    }

    @Test
    public void testarCalculoDesvioPadrao() {
        List<Double> numeros = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0);
        assertEquals(14.142, estatisticas.calcularDesvioPadrao(numeros), 0.001);
    }

    @Test
    public void testarListaVazia() {
        List<Double> numeros = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularMedia(numeros));
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularMediana(numeros));
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularDesvioPadrao(numeros));
    }

    @Test
    public void testarListaComValoresNulos() {
        List<Double> numeros = Arrays.asList(10.0, null, 30.0);
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularMedia(numeros));
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularMediana(numeros));
        assertThrows(IllegalArgumentException.class, () -> estatisticas.calcularDesvioPadrao(numeros));
    }
}
