public class Cliente extends Usuario{
    //atributos
    
    public Carrinho<Produtos> meuCarrinho = new Carrinho<>();

    public Cliente(String nome, String senha, String email) {
        super(nome, senha, email);
        //TODO Auto-generated constructor stub
    }
    


    
}
