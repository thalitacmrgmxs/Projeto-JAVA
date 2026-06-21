package com.implementacoes.Controllers;


import java.io.IOException;

import com.implementacoes.Objetos.Produtos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEstoqController {

    @FXML
    private TextField NomeField;

    @FXML
    private TextField QuantiField;

    @FXML
    private TextField ValorField;

    @FXML
    void Confirmar(ActionEvent event) {
        DonoController.listaEstoque.add(new Produtos(NomeField.getText(),Double.parseDouble(ValorField.getText()), Double.parseDouble(QuantiField.getText()) ));
    }

    public void Start() {
        try {
            //1. carregar o fxml
            java.net.URL fxmlUrl = com.implementacoes.App.class.getResource("/com/implementacoes/AddEstoq.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            //2. Criar uma nova cena com o layout fxml
            Scene CenaAddEstoq = new Scene(root);

            //3.Criar um novo palco
            Stage JanelaAddEstoq = new Stage();
            JanelaAddEstoq.setTitle("Adicionar Produto");
            JanelaAddEstoq.setScene(CenaAddEstoq);

            //4.exibir
            JanelaAddEstoq.show();
        } catch (IOException ex ) {
             ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }


    }

}
