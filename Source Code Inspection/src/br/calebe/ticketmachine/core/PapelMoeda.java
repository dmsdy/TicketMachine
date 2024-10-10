package br.calebe.ticketmachine.core;

/**
 * Classe que representa uma cédula de dinheiro.
 */
public class PapelMoeda {

    // Valor da cédula (ex: 2, 5, 10, 20, 50, 100)
    protected int valor;

    // Quantidade de cédulas desse valor
    protected int quantidade;

    /**
     * Construtor que inicializa o valor e a quantidade de cédulas.
     * 
     * @param valor Valor da cédula.
     * @param quantidade Quantidade de cédulas.
     */
    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor da cédula.
     * 
     * @return Valor da cédula.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Retorna a quantidade de cédulas.
     * 
     * @return Quantidade de cédulas.
     */
    public int getQuantidade() {
        return quantidade;
    }
}
