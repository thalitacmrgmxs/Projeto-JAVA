package com.implementacoes; // Corrigido a formatação


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Gerenciador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
    //Import da Fxml
    @FXML
    private ChoiceBox<String> opcoes_classes;

    @FXML
    private TextField senha;

    @FXML
    private TextField username;
   
    //ação de fazer login
    @FXML
    void fazerLogin(ActionEvent event) throws IOException {

        String escolha = opcoes_classes.getValue(); //varivavel que armazena as opções 
        String usernameString = username.getText(); //variavel que armazena o nome do usuario
        String senhaString = senha.getText();   //variavel que armazena a senha

        System.out.println(Gerenciador.getListaEmp());  //Comando para testar


        // 1. Validação básica de campos vazios
        if (usernameString == null || usernameString.isBlank() || senhaString == null || senhaString.isBlank()) {
            exibirAlerta("Erro de Validação", "Por favor, preencha todos os campos.");
            return;
        }

        // 2. Faz a busca uma única vez e guarda em uma variável local
        Empreendedor encontrado = Gerenciador.buscar(usernameString, senhaString);
        System.out.println(Gerenciador.getSelecionado()); //saída para teste
        
        // 3. Verifica se achou o usuário e se ele bate com o tipo escolhido (Ex:
        // "Dono"/"Empreendedor")
        if (encontrado != null && "Dono".equalsIgnoreCase(escolha)) {

            // Guarda globalmente o usuário que logou
            Gerenciador.setSelecionado(encontrado);
            
            // Muda para a tela do Dono
            App.setRoot("Dono");

        } else {
            // 4. Se falhar, limpa a senha por segurança e avisa o usuário
            senha.clear();
            exibirAlerta("Falha no Login", "Usuário ou senha incorretos para a categoria selecionada.");
        }
    }


    // Método auxiliar para exibir alertas na tela do JavaFX
    private void exibirAlerta(String titulo, String mensagem) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // bloqueando o botão de confirmar

    // inicializando com opções
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] opcoes = { "Empreendedor", "Funcionario", "Cliente" };

        // Popular o ChoiceBox de forma otimizada
        opcoes_classes.setItems(FXCollections.observableArrayList(opcoes));

    }

}
