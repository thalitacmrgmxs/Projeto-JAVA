package com.implementacoes.Objetos;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Gerenciador{
    private static ArrayList<Empreendedor> listaEmp = new ArrayList<Empreendedor>();
    private static Empreendedor dono;

    private Gerenciador() {
     
    }

    public static ArrayList<Empreendedor> getListaEmp() {
        return listaEmp;
    }

    public static void setListaEmp(ArrayList<Empreendedor> listaEmpnew) {
        listaEmp = listaEmpnew;
    }

    public static void adicionar(Empreendedor dono) {
        listaEmp.add(dono);
    } 
    
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

    
   public static Empreendedor getSelecionado() {
        return dono;
   }

   public static void setSelecionado(Empreendedor donoSelecionado) {
        dono = donoSelecionado;
   }


   static {
        adicionar(new Empreendedor("Thalita", "123", "nome@gmail.com", "Designer Com Thalita"));
    }
   }
    

    
    
    
