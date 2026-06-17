package com.implementacoes.Objetos;

import java.util.ArrayList;

public class Gerenciador {
    private ArrayList<Empreendedor> listaEmp = new ArrayList<Empreendedor>();

    public Gerenciador() {
     
        adicionar(new Empreendedor("Thalita", "123", "nome@gmail.com", "Designer Com Thalita"));
    }

    public ArrayList<Empreendedor> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(ArrayList<Empreendedor> listaEmp) {
        this.listaEmp = listaEmp;
    }

    public void adicionar(Empreendedor dono) {
        listaEmp.add(dono);
    } 
    
    public Empreendedor buscar(String nome, String senha) {
        
        for (int i = 0; i < listaEmp.size(); i++ ) {
            if (listaEmp.get(i).getNome().equals(nome) && listaEmp.get(i).getSenha().equals(senha)) {
                return listaEmp.get(i);
            }
        }
        return null;

    }
    
    public Empreendedor selecionado(Empreendedor dono) {
        return dono;
    }

    
    
    
}
