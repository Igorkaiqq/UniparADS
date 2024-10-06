import org.example.ProcessadorDeTexto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProcessadorDeTextoTest {

    private final ProcessadorDeTexto processador = new ProcessadorDeTexto();

    @Test
    public void testInverterPalavras_NormalPhrase_ReturnsReversedWords() {
        String frase = "Olá mundo";
        String resultado = processador.inverterPalavras(frase);
        assertEquals("mundo Olá", resultado);
    }

    @Test
    public void testSubstituirPalavras_WordExistsInPhrase_ReturnsModifiedPhrase() {
        String frase = "Olá mundo";
        String resultado = processador.substituirPalavras(frase, "mundo", "amigo");
        assertEquals("Olá amigo", resultado);
    }

    @Test
    public void testContarOcorrenciasDePalavra_WordExistsInPhrase_ReturnsCorrectCount() {
        String frase = "Olá mundo mundo";
        int resultado = processador.contarOcorrenciasDePalavra(frase, "mundo");
        assertEquals(2, resultado);
    }

    @Test
    public void testInverterPalavras_EmptyOrNullString_ReturnsSameString() {
        assertEquals("", processador.inverterPalavras(""));
        assertNull(processador.inverterPalavras(null));
    }

    @Test
    public void testSubstituirPalavras_EmptyOrNullString_ReturnsSameString() {
        assertEquals("", processador.substituirPalavras("", "a", "b"));
        assertNull(processador.substituirPalavras(null, "a", "b"));
    }

    @Test
    public void testContarOcorrenciasDePalavra_EmptyOrNullString_ReturnsZero() {
        assertEquals(0, processador.contarOcorrenciasDePalavra("", "mundo"));
        assertEquals(0, processador.contarOcorrenciasDePalavra(null, "mundo"));
    }

}
