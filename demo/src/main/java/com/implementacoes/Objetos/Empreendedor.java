/*Classe criada para criar 'Donos de lojas' que são capazes de acessar
a lista de funcionarios, as vendas e compras do mês, informações da loja e
atribuir tasks para seus funcionarios, além de contratar ou demitir.
*/

package com.implementacoes.Objetos;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Empreendedor extends Usuario{

    //atributos
    private String nomeEmpreendimento;
    private int id_empresa; 
    private double vendas;
    private double compras;
    private ArrayList<Funcionario> listaFuncionarios;
    //Construtor
    public Empreendedor(String nome, String senha, String email,String nomeEmpreendimento) {
        super(nome, senha, email);
        this.nomeEmpreendimento = nomeEmpreendimento;
        id_empresa = ThreadLocalRandom.current().nextInt(0, 999);
        //TODO Auto-generated constructor stub
    }
    //getters and setters
    public String getNomeEmpreendimento() {
        return nomeEmpreendimento;
    }

    public void setNomeEmpreendimento(String nomeEmpreendimento) {
        this.nomeEmpreendimento = nomeEmpreendimento;
    }

    @Override
    public String toString() {
        return "Empreendedor [nomeEmpreendimento=" + nomeEmpreendimento + ", id_empresa=" + id_empresa + ", vendas="
                + vendas + ", compras=" + compras + ", listaFuncionarios=" + listaFuncionarios + "]";
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }

    //métodos especiais 
    public boolean demitir(Funcionario f) {
        //implementar
        return true;
    }
    public boolean contratar(Funcionario f) {
        //implementar
        return true;
    }
    //

   
 
}
