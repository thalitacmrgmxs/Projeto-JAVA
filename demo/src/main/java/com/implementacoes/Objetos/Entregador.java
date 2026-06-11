public class Entregador extends Funcionario {
    //atributos
    private int gasolina_atual;

    public Entregador(String nome, String senha, String email, float salario, String cargo, int data_de_admissao) {
        super(nome, senha, email, salario, cargo, data_de_admissao);
        gasolina_atual = 100;
    }

    //método para receber gasolina de forma que não ultrapasse 100
    public int getGasolina_atual(int quant) {
       return gasolina_atual;
    }

    public void setGasolina_atual(int quant) {
        if (gasolina_atual + quant <= 100) {
            gasolina_atual += quant;
        }
        else {
            gasolina_atual += quant - ((gasolina_atual + quant) - 100);
        }
        
    }

    //método especiais
    public void entregar() {
        
    }

    public void coletar() {
        
    }

    
}
