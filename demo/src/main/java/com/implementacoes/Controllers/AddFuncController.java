package com.implementacoes.Controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddFuncController {

    public AddFuncController() {
    
    

    try {
     //1. carrega o fxml
     java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/primary.fxml");
     FXMLLoader loader = new FXMLLoader((fxmUrl));
     Parent root = loader.load();

     //2.criar nova cena com layout carregado fxml
     Scene CenaADDFormulario = new Scene(root);

     //3. criar um novo palco
     Stage JanelaAddFuncionario= new Stage();
     JanelaAddFuncionario.setTitle("Adicionar Funcionario");
     JanelaAddFuncionario.setScene(CenaADDFormulario);

     //4. exibi a janela
     JanelaAddFuncionario.show();

    //Captura de erro
    } catch (IOException ex) {
        ex.printStackTrace();
        System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
    }
    

}}



    

