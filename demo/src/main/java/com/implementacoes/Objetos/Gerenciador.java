package com.implementacoes.Objetos; //formatado

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class Gerenciador {
    // variaveis static(acessiveis a todos)
    private static ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    public static ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList(); // A lista de // Funcionario é  // distribu// para as outras// classes dentro // do pacote
    private static ObservableList<Produtos> listaEstoque = FXCollections.observableArrayList();
    private static Usuario user;

    // Construtor
    private Gerenciador() {

    }

    // métodos
    
    // retonar o selecionado
    public static Usuario getSelecionado() {
        return user;
    }

    // determinar o selecionado
    public static void setSelecionado(Usuario donoSelecionado) {
        user = donoSelecionado;
    }

    public static ObservableList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void setListaFuncionarios(ObservableList<Funcionario> listaFuncionarios) {
        Gerenciador.listaFuncionarios = listaFuncionarios;
    }

    public static ObservableList<Produtos> getListaEstoque() {
        return listaEstoque;
    }

    public static void setListaEstoque(ObservableList<Produtos> listaEstoque) {
        Gerenciador.listaEstoque = listaEstoque;
    }

    public static Usuario getDono() {
        return user;
    }

    public static void setDono(Empreendedor dono) {
        Gerenciador.user = dono;
    }
    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        Gerenciador.listaUsuario = listaUsuario;
    }

    //Métodos 
    public static void adicionar(Usuario dono) {
        listaUsuario.add(dono); // adicionar um usuario a uma lista com upcasting
    }

    // método criado para preencher tabelas
    public static ObservableList<Funcionario> preencherF(String dono) {
        final ObservableList<Funcionario> listaTemporaria = FXCollections.observableArrayList();

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (dono.equalsIgnoreCase(listaFuncionarios.get(i).getChefe())) {
                listaTemporaria.add(listaFuncionarios.get(i));
            }
        }

        return listaTemporaria;

    }

    public static ObservableList<Produtos> preencherE(String dono) {
        final ObservableList<Produtos> listaTemporaria = FXCollections.observableArrayList();
            
       
        for (int i = 0; i < listaEstoque.size(); i++) {
            //verificando se o nome do dono é igual ao proprietario
            if (dono.equalsIgnoreCase(listaEstoque.get(i).getProprietario())) {
                listaTemporaria.add(listaEstoque.get(i));
            }
        }

        return listaTemporaria;

    }

    // método criado para buscar um funcionario especifico
    public static Usuario buscar(String nome, String senha) {
        // Evita erro se quem chamou o método passou parâmetros nulos
        if (nome == null || senha == null) {
            return null;
        }

        for (int i = 0; i < listaUsuario.size(); i++) {
            Usuario emp = listaUsuario.get(i);

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

   
    // método selecionado quando o programa é ligado
    static {
        adicionar(new Empreendedor("Thalita", "123", "nome@gmail.com", "Designer Com Thalita"));
        adicionar(new Empreendedor("joão", "12", "jeve@gmail.com ", "hq"));
        adicionar(new Funcionario("sofia", "1234","email" , 0, "Estoquista", null, "Thalita"));
        adicionar(new Entregador("gabriel", "02", "email", 2500, "Entregador", LocalDate.of(1908, 01, 02), "joão", 30));
        adicionar(new Atendente("maria", "111", "email", 1200, "Atendente", LocalDate.of(2000,02,01), "Thalita"));
        
        listaFuncionarios.addAll(
                    new Funcionario("Felipe", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2), "thalita"),
                    new Funcionario("Maria", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2), "thalita"),
                    new Funcionario("ferdinando", "1234", "email", 2000, "vendedor", LocalDate.of(2006, 05, 12), "joão"));
               
        
        listaEstoque.add(new Produtos("pão", 2.50, 10.0,"Thalita"));
        listaEstoque.add(new Produtos("doce", 5.0, 4.0, "joão"));    
    }


    
        
        
}
