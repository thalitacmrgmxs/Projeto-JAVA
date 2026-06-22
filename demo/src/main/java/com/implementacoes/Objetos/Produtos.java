package com.implementacoes.Objetos;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public class Produtos {
    private final StringProperty nome;
    private final DoubleProperty valor;
    private final DoubleProperty quant;
    private final StringProperty proprietario;

    public Produtos(String nome, double valor, double quant) {
        this.nome = new SimpleStringProperty(nome);
        this.valor = new SimpleDoubleProperty(valor);
        this.quant = new SimpleDoubleProperty(quant);
        this.proprietario = new SimpleStringProperty("");
    }

    public Produtos(String nome, Double valor, Double quant, String proprietario) {
       this.nome = new SimpleStringProperty(nome);
        this.valor = new SimpleDoubleProperty(valor);
        this.quant = new SimpleDoubleProperty(quant);
        this.proprietario = new SimpleStringProperty(proprietario);
    }



    // Getters e Setters para compatibilidade com seu código
    public String getNome() { return nome.get(); }
    public void setNome(String valor) { this.nome.set(valor); }
    
    public double getValor() { return valor.get(); }
    public void setValor(double valor) { this.valor.set(valor); }

    public double getQuant() { return quant.get(); }
    public void setQuant(double valor) { this.quant.set(valor); }

    // Métodos Property necessários para a TableView monitorar mudanças
    public StringProperty nomeProperty() { return nome; }
    public DoubleProperty valorProperty() { return valor; }
    public DoubleProperty quantProperty() { return quant; }

    @Override
    public String toString() {
        return "Produtos [nome=" + nome + ", valor=" + valor + ", quant=" + quant + "]";
    }


    
}
