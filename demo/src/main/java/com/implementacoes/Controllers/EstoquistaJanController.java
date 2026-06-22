package com.implementacoes.Controllers;

import java.io.IOException;

import com.implementacoes.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class EstoquistaJanController {

    @FXML
    private Text FuncFuncao;

    @FXML
    private Text FuncNome;

    @FXML
    private Text FuncSalario;

    @FXML
    private TableColumn<?, ?> NomeColumnEst;

    @FXML
    private TableColumn<?, ?> QuantColumnEst;

    @FXML
    private TableView<?> TableEstoqueProd;

    @FXML
    private TableColumn<?, ?> TaksColumn;

    @FXML
    private TableView<?> TaskTable;

    @FXML
    private TableColumn<?, ?> ValorColumnEst;

    @FXML
    void voltar(ActionEvent event) {
         // Tratamento de erro e exceção try_catch
        try {
            App.setRoot("Login");   //mudando a cena
            //Gerenciador.setListaEstoque(FXCollections.observableArrayList()); //resetando a lista
            //Gerenciador.setListaFuncionarios(FXCollections.observableArrayList()); //resetando a lista
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

}
