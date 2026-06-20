//classe para os diversos produtos

package com.implementacoes.Objetos;
public class Produtos {
    //atributos
    private String nome;
    private double valor;
    private double quant;
    
   

   
    
    public Produtos(String nome, double valor, double quant) {
        this.nome = nome;
        this.valor = valor;
        this.quant = quant;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
     public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }
    
}
