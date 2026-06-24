package com.implementacoes.Objetos;

import java.time.LocalDate;

public class Atendente  extends Funcionario{
    private Carrinho<Produtos> carinho;
    
    
    public Atendente(String nome, String senha, String email, float salario, String cargo, LocalDate data_de_admissao, String chefe) {
        super(nome, senha, email, salario, cargo, data_de_admissao, chefe);
        this.carinho = new Carrinho<>();
    }

    public Carrinho<Produtos> getCarinho() {
        return carinho;
    }

    public void setCarinho(Carrinho<Produtos> carinho) {
        this.carinho = carinho;
    }
    
    

    //método para acessar os valores dos produtos

}
