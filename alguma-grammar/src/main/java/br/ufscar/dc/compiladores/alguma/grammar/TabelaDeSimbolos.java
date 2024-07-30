package br.ufscar.dc.compiladores.alguma.grammar;

import java.util.HashMap;
import java.util.Map;

public class TabelaDeSimbolos {
    public enum AlgumaGrammar {
        INTEIRO,
        REAL,
        LITERAL,
        VOID,
        REGISTRO,
        LOGICO,
        INVALIDO,
    }

    class EntradaTabelaDeSimbolos {
        String nome;
        AlgumaGrammar tipo;
        boolean flag_ponteiro = false;

        private EntradaTabelaDeSimbolos(String nome, AlgumaGrammar tipo, boolean flag_ponteiro) {
            this.nome = nome;
            this.tipo = tipo;
            this.flag_ponteiro = flag_ponteiro;
        }
    }

    private final Map<String, EntradaTabelaDeSimbolos> tabela;

    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, AlgumaGrammar tipo, boolean flag_ponteir) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, flag_ponteir));
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public AlgumaGrammar verificar(String nome) {
        return tabela.get(nome).tipo;
    }

    public boolean verificar_ponteiro(String nome) {
        return tabela.get(nome).flag_ponteiro;
    }

}
