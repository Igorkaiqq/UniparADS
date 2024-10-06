import org.example.CalculadoraAvancada;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculadoraAvancadaTest {

    private final CalculadoraAvancada calculadora = new CalculadoraAvancada();


    @Test
    public void testPotencia_PositiveBaseAndExponent_ReturnsCorrectResult() {
        double resultado = calculadora.potencia(2, 3);
        assertEquals(8, resultado, 0.0001);
    }

    @Test
    public void testRaizQuadrada_PositiveNumber_ReturnsCorrectResult() {
        double resultado = calculadora.raizQuadrada(9);
        assertEquals(3, resultado, 0.0001);
    }

    @Test
    public void testLogaritmoNatural_PositiveNumber_ReturnsCorrectResult() {
        double resultado = calculadora.logaritmoNatural(Math.E);
        assertEquals(1, resultado, 1e-5);
    }

    @Test
    public void testRaizQuadrada_NegativeNumber_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.raizQuadrada(-9));
    }

    @Test
    public void testLogaritmoNatural_NegativeOrZeroNumber_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.logaritmoNatural(0));
    }

}
