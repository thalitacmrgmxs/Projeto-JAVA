/*Classe criada para criação dos funcionarios, a qual será utilizado
futuramente up e down castings para organizar os fucionarios
            IMPORTANTE: usar interface para os métodos dos funcionarios
*/

package com.implementacoes.Objetos;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;

public class Funcionario extends Usuario implements UsuarioAcoes{
    //atributos
    private float salario;
    private String cargo;
    private String chefe;
    //private int id;
    
    private LocalDate data_de_admissao;

    private double tarefas_Atuais;
   

    private ArrayList<String> tarefas;
    
    //Construtor
    public Funcionario(String nome, String senha, String email,float salario, String cargo, LocalDate data_de_admissa,String chefe) {
        super(nome, senha, email);
        this.salario = salario;
        this.cargo = cargo;
        this.data_de_admissao = data_de_admissao;
        this.tarefas_Atuais = 0;
        this.chefe = chefe;

        tarefas = new ArrayList<String>();
    }

    public Funcionario(String nome, String senha, String email,float salario, String cargo, LocalDate data_de_admissao) {
        super(nome, senha, email);
        this.salario = salario;
        this.cargo = cargo;
        this.data_de_admissao = data_de_admissao;
        this.tarefas_Atuais = 0;
        this.chefe = "";

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

    public LocalDate getData_de_admissao() {
        return data_de_admissao;
    }

    public void setData_de_admissao(LocalDate data_de_admissao) {
        this.data_de_admissao = data_de_admissao;
    }
     public double getTarefas_Atuais() {
        return tarefas_Atuais;
    }
    public void setTarefas_Atuais(double tarefas_Atuais) {
        this.tarefas_Atuais = tarefas_Atuais;
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
        return "Funcionario [" + "Nome: " + getNome() + ", cargo= " + cargo + ", tarefas_Atuais= " + tarefas_Atuais;
    }

    public String getChefe() {
        return chefe;
    }

    @Override
    public String Sinal() {
        // TODO Auto-generated method stub
        return ("Funcionario operando");
    }

    
    

    
    
    
   
    


    
}
