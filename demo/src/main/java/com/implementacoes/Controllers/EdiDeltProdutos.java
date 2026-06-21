package com.implementacoes.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Produtos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EdiDeltProdutos implements Initializable {
    
    @FXML
    private ChoiceBox<Produtos> OpcoesProdMenu;

    @FXML
    private TextField produtoNome;

    @FXML
    private TextField produtoQuant;

    @FXML
    private TextField produtoValor;

    @FXML
    void Editar(ActionEvent event) {
     //acessando o produto
     Produtos produtoSel = OpcoesProdMenu.getValue();
     
     //atribuir valores ao objeto do produto
     if (produtoSel != null) {
        produtoSel.setNome(produtoNome.getText());
        produtoSel.setQuant(Double.parseDouble(produtoQuant.getText()));
        produtoSel.setValor(Double.parseDouble(produtoValor.getText()));
     }

     // 3. Força a ChoiceBox e a tela a atualizarem visualmente
        int index = DonoController.listaEstoque.indexOf(produtoSel);
        if (produtoSel.getQuant() <= 0) {
            DonoController.listaEstoque.remove(index);
        }else {
        DonoController.listaEstoque.set(index, produtoSel);
        }
     //limpa
     produtoNome.clear();
     produtoQuant.clear();
     produtoValor.clear();

    }
    private void PrencherLacunas(Produtos produto) {
            Produtos produtoSel = OpcoesProdMenu.getValue();
            produtoNome.setText(produtoSel.getNome());
            produtoQuant.setText(String.valueOf(produtoSel.getQuant()));
            produtoValor.setText(String.valueOf(produtoSel.getValor()));
        }
    public void start() {
        try {
            //encontrar e inicializar o fxml
            java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/Del_edit_produtos.fxml");

            FXMLLoader loader = new FXMLLoader(fxmUrl);
            Parent root = loader.load();

            //criar a cena
            Scene cenaDelEditProdutos = new Scene(root);

            //criar a janela
            Stage JanelaDelEditProdutos = new Stage();
            JanelaDelEditProdutos.setTitle("Editar Produtos");
            JanelaDelEditProdutos.setScene(cenaDelEditProdutos);

            JanelaDelEditProdutos.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //adicionando as opções ao menu
        OpcoesProdMenu.setItems(DonoController.listaEstoque);
        
        //ouvinte
        OpcoesProdMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, ProdutoSelecionado) -> {
            if (ProdutoSelecionado != null) {
                PrencherLacunas(ProdutoSelecionado);
            }
        });



      
        //pegar o selecionado
        
    }
    
}
