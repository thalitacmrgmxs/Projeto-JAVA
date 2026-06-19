package com.implementacoes.Objetos;

public interface Funcionarios_interface {
    public float getSalario() {
        
    }

    public void setSalario(float salario) {
        
    }

    public String getCargo() {
        
    }

    public void setCargo(String cargo) {
        
    }

    public int getData_de_admissao() {
       
    }

    public void setData_de_admissao(int data_de_admissao) {
       
    }
    
    //métodos especiais

    public ArrayList<String> getTarefas() { 
       
    }
    public void setTarefas(ArrayList<String> tarefas) { 
        
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
}
