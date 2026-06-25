package com.implementacoes.Objetos;

import java.time.LocalDate;

public class Entregador extends Funcionario {
    //atributos
    private int gasolina_atual;
    private int gasolina_gasta;

    public Entregador(String nome, String senha, String email, float salario, String cargo, LocalDate data_de_admissao,
            String chefe,int gasolina_atual) {
        super(nome, senha, email, salario, cargo, data_de_admissao, chefe);
        this.gasolina_atual = gasolina_atual;
    }

    //método para receber gasolina de forma que não ultrapasse 100
    public int getGasolina_atual() {
       return gasolina_atual;
    }

    public void setGasolina_atual(int quant) {
        if (gasolina_atual + quant <= 100) {
            gasolina_atual += quant;
            if (quant >= 1) {
            gasolina_gasta += quant;}
            else {
                gasolina_gasta += -1*quant;
            }
        }
        else {
            gasolina_atual += quant - ((gasolina_atual + quant) - 100);
            gasolina_gasta = quant - ((gasolina_atual + quant) - 100);
            if (quant >= 1) {
                gasolina_gasta = quant - ((gasolina_atual + quant) - 100);
            } else {
                 gasolina_gasta = -1*(quant - ((gasolina_atual + quant) - 100));
            }
        }
        
    }

    public int getGasolina_gasta() {
        return gasolina_gasta;
    }

    public void setGasolina_gasta(int gasolina_gasta) {
        this.gasolina_gasta = gasolina_gasta;
    }

    public void setGasolina_gasta() {
        this.gasolina_gasta = 5;
    }
    
        //método especiais
    public void entregar() {
        
    }

    public void coletar() {
        
    }

    
}
