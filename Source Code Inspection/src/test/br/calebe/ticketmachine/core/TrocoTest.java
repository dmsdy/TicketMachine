package br.calebe.ticketmachine.core;

import java.util.Iterator;
//
/**
 * Classe que representa o troco da máquina de tickets.
 * Calcula a quantidade de cédulas necessárias para devolver o troco.
 * 
 * @author Calebe de Paula Bianchini
 */
class Troco {

    // Array que armazena as cédulas para o troco, organizadas por valor
    protected PapelMoeda[] papeisMoeda;

    /**
     * Construtor que inicializa a quantidade de cédulas de troco.
     * Calcula quantas cédulas de cada valor são necessárias para formar o troco.
     * 
     * @param valor Valor total do troco.
     */
    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6]; // Array de cédulas disponíveis
        int[] valoresCedulas = {100, 50, 20, 10, 5, 2}; // Denominações de cédulas

        // Loop para calcular quantas cédulas de cada valor são necessárias
        for (int i = 0; i < valoresCedulas.length; i++) {
            int count = valor / valoresCedulas[i];  // Calcula quantas cédulas cabem no valor
            valor %= valoresCedulas[i];  // Atualiza o valor restante
            papeisMoeda[5 - i] = new PapelMoeda(valoresCedulas[i], count);  // Armazena as cédulas
        }
    }

    /**
     * Retorna um iterador para percorrer as cédulas do troco.
     * 
     * @return Iterador das cédulas do troco.
     */
    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this); // Retorna um iterador da classe TrocoIterator
    }

    /**
     * Classe interna que implementa o iterador para percorrer o troco.
     */
    class TrocoIterator implements Iterator<PapelMoeda> {

        // Referência ao troco que está sendo percorrido
        protected Troco troco;

        /**
         * Construtor do iterador, recebe o troco que será iterado.
         * 
         * @param troco Troco que será iterado.
         */
        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        /**
         * Verifica se ainda existem cédulas para serem iteradas.
         * 
         * @return true se houver mais cédulas, false se não houver.
         */
        @Override
        public boolean hasNext() {
            // Percorre o array de cédulas para verificar se há cédulas não nulas
            for (int i = 5; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true; // Retorna true se encontrar cédulas
                }
            }
            return false; // Retorna false se não houver mais cédulas
        }

        /**
         * Retorna a próxima cédula do troco.
         * 
         * @return Próxima cédula ou null se não houver mais.
         */
        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;

            // Encontra a próxima cédula não nula no array
            for (int i = 5; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i]; // Armazena a cédula encontrada
                    troco.papeisMoeda[i] = null; // Marca essa cédula como "usada"
                    break; // Sai do loop após encontrar a cédula
                }
            }

            return ret; // Retorna a cédula encontrada
        }
    }
}
