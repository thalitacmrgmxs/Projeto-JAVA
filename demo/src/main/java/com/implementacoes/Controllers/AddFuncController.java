package com.implementacoes.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFuncController implements Initializable {
    //Construtor vazio
    public AddFuncController() {}
    
    //FXMLS
     @FXML
    private TextField FuncEmail;

    @FXML
    private TextField funcAdmissao;

    @FXML
    private ChoiceBox<String> funcCargo;

    @FXML
    private TextField funcNome;

    @FXML
    private TextField funcSalario;

    @FXML
    void Confirmar(ActionEvent event) {

    }

    //método para lançar a janela
    public void start() {
        try {
     //1. carrega o fxml
     java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/AddFuncionario.fxml");
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] opcoes = {"Estoquista", "Atendente", "Entregador"};
        

        // Popular o ChoiceBox de forma otimizada
        funcCargo.setItems(FXCollections.observableArrayList(opcoes));
        
    }
    



}



    

