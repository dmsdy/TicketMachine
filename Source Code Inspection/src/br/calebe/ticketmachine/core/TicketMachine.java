package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
//
/**
 * Classe que representa a máquina de tickets.
 * Controla a inserção de dinheiro e a impressão do ticket.
 * 
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    // Valor do ticket que a máquina está vendendo
    protected int valor;

    // Saldo acumulado na máquina (quanto dinheiro foi inserido)
    protected int saldo;

    // Valores válidos de cédulas que podem ser inseridos (2, 5, 10, 20, 50, 100)
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    /**
     * Construtor da máquina de tickets.
     * Inicializa a máquina com o valor do ticket e saldo zero.
     * 
     * @param valor Valor do ticket.
     */
    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;  // Inicializa o saldo como zero
    }

    /**
     * Insere uma quantia de dinheiro na máquina.
     * Verifica se a quantia é válida antes de adicionar ao saldo.
     * 
     * @param quantia Valor da cédula inserida.
     * @throws PapelMoedaInvalidaException Se a quantia for inválida (não é um valor aceito).
     */
    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        // Verifica se o valor inserido é maior que zero
        if (quantia <= 0) {
            throw new PapelMoedaInvalidaException(); // Lança exceção se o valor for negativo ou zero
        }

        // Verifica se a quantia inserida é um valor válido
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true; // Encontra se o valor é válido
            }
        }

        // Se não encontrou a cédula entre as válidas, lança exceção
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }

        // Adiciona a quantia ao saldo
        this.saldo += quantia;
    }

    /**
     * Retorna o saldo atual da máquina.
     * 
     * @return Saldo acumulado.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Retorna o troco restante após a compra do ticket.
     * Usa a classe Troco para calcular e devolver o troco correto.
     * 
     * @return Iterador das cédulas do troco.
     */
    public Iterator<PapelMoeda> getTroco() {
        int trocoValor = saldo - valorTicket; // Calcula o valor do troco
        if (trocoValor > 0) {
            Troco troco = new Troco(trocoValor); // Cria um objeto Troco com o valor do troco
            return troco.getIterator(); // Retorna o iterador das cédulas do troco
        }
        return null; // Se não houver troco, retorna null
    }

    /**
     * Imprime o ticket se o saldo for suficiente.
     * 
     * @return String com o ticket impresso.
     * @throws SaldoInsuficienteException Se o saldo for menor que o valor do ticket.
     */
    public String imprimir() throws SaldoInsuficienteException {
        // Verifica se o saldo é suficiente para o valor do ticket
        if (saldo < valor) {
            throw new SaldoInsuficienteException(); // Lança exceção se o saldo for insuficiente
        }

        // Cria uma representação do ticket
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result; // Retorna o ticket como string
    }
}
