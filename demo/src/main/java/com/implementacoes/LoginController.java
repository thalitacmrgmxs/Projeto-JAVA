package com.implementacoes;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
    
    @FXML
    private ChoiceBox<String> opcoes_classes;

    @FXML
    private TextField senha;

    @FXML
    private TextField username;

    @FXML
    void fazerLogin(ActionEvent event) throws IOException{
        //obter a escolha de opções
        String escolha = opcoes_classes.getValue();
        System.out.println(escolha);
        //obter o nome do usuario
        String usernameString = username.getText();
        System.out.println(usernameString);
        //obter a senha
        String senhaString = senha.getText();
        System.out.println(senhaString);

        //muda a página
        App.setRoot("Dono");
        
    }

    //bloqueando o botão de confirmar
    
    //inicializando com opções
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] opcoes = {"Empreendedor", "Funcionario", "Cliente"};
        
        // Popular o ChoiceBox de forma otimizada
        opcoes_classes.setItems(FXCollections.observableArrayList(opcoes));

    }

}
