public class Empreendedor extends Usuario{

    //atributos
    private String nomeEmpreendimento;
    private int id_empresa; 

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
