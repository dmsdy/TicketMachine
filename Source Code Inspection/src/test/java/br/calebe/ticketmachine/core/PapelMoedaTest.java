package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe PapelMoeda.
 * Utiliza Particionamento de Equivalência para testar valores válidos e inválidos.
 */
public class PapelMoedaTest {

    @Test
    public void testConstrutorValoresValidos() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor());
        assertEquals(5, papelMoeda.getQuantidade());
    }

    @Test
    public void testConstrutorValoresInvalidos() {
        // Particionamento de Equivalência: Valores negativos ou zero
        assertThrows(IllegalArgumentException.class, () -> {
            new PapelMoeda(-10, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new PapelMoeda(0, 5);
        });
    }
}
