package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Troco.
 * Utiliza Teste de Caminho Base e Grafo de Fluxo.
 */
public class TrocoTest {

    @Test
    public void testTroco() {
        Troco troco = new Troco(87); // O troco deve ser 87
        Iterator<PapelMoeda> iterator = troco.getIterator();

        // Teste de Caminho Base: Verificando se o iterador fornece os valores corretos
        assertTrue(iterator.hasNext());
        PapelMoeda cédula = iterator.next();
        assertEquals(50, cédula.getValor());
        assertEquals(1, cédula.getQuantidade());

        assertTrue(iterator.hasNext());
        cédula = iterator.next();
        assertEquals(20, cédula.getValor());
        assertEquals(1, cédula.getQuantidade());

        assertTrue(iterator.hasNext());
        cédula = iterator.next();
        assertEquals(10, cédula.getValor());
        assertEquals(1, cédula.getQuantidade());

        assertTrue(iterator.hasNext());
        cédula = iterator.next();
        assertEquals(5, cédula.getValor());
        assertEquals(1, cédula.getQuantidade());

        assertTrue(iterator.hasNext());
        cédula = iterator.next();
        assertEquals(2, cédula.getValor());
        assertEquals(1, cédula.getQuantidade());

        assertFalse(iterator.hasNext()); // Não deve haver mais cédulas
    }
}
