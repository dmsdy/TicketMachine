package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe TicketMachine.
 * Utiliza Tabela de Decisão e Análise de Valor Limite.
 */
public class TicketMachineTest {

    private TicketMachine ticketMachine;

    @BeforeEach
    public void setup() {
        ticketMachine = new TicketMachine(10); // O valor do ticket é 10
    }

    @Test
    public void testInserirCédulaValida() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(10);
        assertEquals(10, ticketMachine.getSaldo());
    }

    @Test
    public void testInserirCédulaInvalida() {
        // Tabela de Decisão: Testar cédulas inválidas
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            ticketMachine.inserir(3); // Cédula inválida
        });
    }

    @Test
    public void testImprimirTicketComSaldoInsuficiente() {
        // Teste de Fluxo de Dados: Testar impressão com saldo insuficiente
        assertThrows(SaldoInsuficienteException.class, () -> {
            ticketMachine.imprimir();
        });
    }

    @Test
    public void testImprimirTicketComSaldoSuficiente() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        ticketMachine.inserir(20);
        String ticket = ticketMachine.imprimir();
        assertTrue(ticket.contains("R$ 20,00"));
    }
}
