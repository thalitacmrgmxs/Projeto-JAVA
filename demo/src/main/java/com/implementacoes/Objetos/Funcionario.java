import java.util.ArrayList;

public class Funcionario extends Usuario {
    //atributos
    private float salario;
    private String cargo;
    //private int id;
    private int data_de_admissao;
    private ArrayList<String> tarefas;
    
    //Construtor
    public Funcionario(String nome, String senha, String email,float salario, String cargo, int data_de_admissao) {
        super(nome, senha, email);
        this.salario = salario;
        this.cargo = cargo;
        this.data_de_admissao = data_de_admissao;

        tarefas = new ArrayList<String>();
    }
    //getters and setters 
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getData_de_admissao() {
        return data_de_admissao;
    }

    public void setData_de_admissao(int data_de_admissao) {
        this.data_de_admissao = data_de_admissao;
    }
    
    //métodos especiais

    public ArrayList<String> getTarefas() { 
        return tarefas;
    }
    public void setTarefas(ArrayList<String> tarefas) { 
        this.tarefas = tarefas;
    }
    
    public boolean cumprirTarefa(int indice) {
        // Corrigido: Valida se o índice existe na lista antes de remover
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice); // Remove usando o método correto do ArrayList
            return true; // Retorna verdadeiro se removeu com sucesso
        }
        return false; // Retorna falso se o índice for inválido
    }

    public String mostrarTarefas() {
        for (String task: tarefas ) {
            System.out.println(task+"");
        }
        return "";
    }

    @Override
    public String toString() {
        return "Funcionario [salario=" + salario + ", cargo=" + cargo + ", data_de_admissao=" + data_de_admissao + "]";
    }
    

    
    
    
   
    


    
}
