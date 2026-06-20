/*Classe criada para criar 'Donos de lojas' que são capazes de acessar
a lista de funcionarios, as vendas e compras do mês, informações da loja e
atribuir tasks para seus funcionarios, além de contratar ou demitir.
*/

package com.implementacoes.Objetos;
public class Empreendedor extends Usuario{

    //atributos
    private String nomeEmpreendimento;
    private int id_empresa; 

    //Construtor
    public Empreendedor(String nome, String senha, String email,String nomeEmpreendimento) {
        super(nome, senha, email);
        this.nomeEmpreendimento = nomeEmpreendimento;
        //TODO Auto-generated constructor stub
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

    
    
    
}
