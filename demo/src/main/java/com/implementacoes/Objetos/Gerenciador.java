package com.implementacoes.Objetos; //formatado

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Gerenciador{
    //variaveis static(acessiveis a todos)
    private static ArrayList<Empreendedor> listaEmp = new ArrayList<Empreendedor>();
    private static Empreendedor dono;

    //Construtor
    private Gerenciador() {
     
    }

    //métodos
    public static ArrayList<Empreendedor> getListaEmp() {
        return listaEmp;    //retornar a lista de empreendedores
    }

    public static void setListaEmp(ArrayList<Empreendedor> listaEmpnew) {
        listaEmp = listaEmpnew; //Altera a lista
    }

    public static void adicionar(Empreendedor dono) {
        listaEmp.add(dono); //adicionar um empreendedor a lista
    } 
    
    //método criado para buscar um funcionario especifico
    public static Empreendedor buscar(String nome, String senha) {
    // Evita erro se quem chamou o método passou parâmetros nulos
    if (nome == null || senha == null) {
        return null; 
    }

    for (int i = 0; i < listaEmp.size(); i++) {
        Empreendedor emp = listaEmp.get(i);
        
        // Evita testar posições vazias da lista
        if (emp != null && emp.getNome() != null && emp.getSenha() != null) {
            
            // equalsIgnoreCase no nome permite logar mesmo errando o Tab/Caps
            if (emp.getNome().equalsIgnoreCase(nome) && emp.getSenha().equals(senha)) {
                return emp;
            }
        }
    }
    return null; // Não encontrou nenhum correspondente
}



    //retonar o selecionado 
   public static Empreendedor getSelecionado() {
        return dono;
   }
   //determinar o selecionado
   public static void setSelecionado(Empreendedor donoSelecionado) {
        dono = donoSelecionado;
   }

   //método selecionado quando o programa é ligado
   static {
        adicionar(new Empreendedor("Thalita", "123", "nome@gmail.com", "Designer Com Thalita"));
        adicionar(new Empreendedor("joão", "12", "jeve@gmail.com ", "hq"));
    }
   }
    

    
    
    
