package com.implementacoes.Objetos;
public class Cliente extends Usuario implements UsuarioAcoes{
    //atributos
    
    public Carrinho<Produtos> meuCarrinho = new Carrinho<>();

    public Cliente(String nome, String senha, String email) {
        super(nome, senha, email);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String Sinal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sinal'");
    }

    
    


    
}
