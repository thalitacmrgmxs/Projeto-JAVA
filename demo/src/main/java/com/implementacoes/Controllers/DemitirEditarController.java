package com.implementacoes.Controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DemitirEditarController {

    @FXML
    private Button Demitir;

    @FXML
    private Button Edit;

    @FXML
    private TextField FuncAdmissao;

    @FXML
    private TextField FuncFuncao;

    @FXML
    private TextField FuncNome;

    @FXML
    private ChoiceBox<?> FuncOpcoesMenu;

    @FXML
    private TextField FuncSalario;

    @FXML
    private TextField FuncTarefas;

    public void start() {

        try {
        //1. carrega o fxml
        java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/Demitir_editar_funcionario.fxml");
        FXMLLoader loader = new FXMLLoader((fxmUrl));
        Parent root = loader.load();

        //Criar a cena
        Scene cenaDemitirEditar = new Scene(root);

        //Criando a janela
        Stage JanelaDemitirEditar = new Stage();
        JanelaDemitirEditar.setScene(cenaDemitirEditar);
        JanelaDemitirEditar.setTitle("Demitir e Editar");
        
        //mostrando
        JanelaDemitirEditar.show();
        
        }catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

}
