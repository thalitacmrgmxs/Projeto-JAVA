package com.implementacoes.Controllers;

import java.io.IOException;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CriarContaController {

    public CriarContaController() {
        
    }
    @FXML
    private TextField EmailField;

    @FXML
    private TextField EmpresaField;

    @FXML
    private TextField NomeField;

    @FXML
    private TextField SenhaField;

    @FXML
    public boolean Confirmar(ActionEvent event) {
        try {
            boolean encontrado = false;
            //verificação de existencia
            for (int i = 0; i < Gerenciador.getListaUsuario().size(); i++) {
                if (NomeField.getText().equalsIgnoreCase(Gerenciador.getListaUsuario().get(i).getNome())) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                Gerenciador.adicionar(new Empreendedor(NomeField.getText(), SenhaField.getText(), EmailField.getText(), EmpresaField.getText()));
                return true;
            } else {
                exibirAlerta("Usuario Existente", "Altere o nome de usuario");
                return false;
            }
            
        
            
        } catch (Exception e) {
            System.out.println("Deu erro na criação de conta");
            return false;
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

    public void start() {
        try {
            java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/CriarContaJan.fxml");
            FXMLLoader loader = new FXMLLoader(fxmUrl);
            Parent root = loader.load();

            /* 
            // CAPTURA O CONTROLLER REAL CRIADO PELO FXML
            EdiDeltProdutos controllerReal = loader.getController();
            
            // Injeta o usuário na instância real da tela e preenche o menu
            controllerReal.initUsuario(user);
            */

            Scene cenaDelEditProdutos = new Scene(root);
            Stage JanelaDelEditProdutos = new Stage();
            JanelaDelEditProdutos.setTitle("Criar Conta");
            JanelaDelEditProdutos.setScene(cenaDelEditProdutos);           
            JanelaDelEditProdutos.show();

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

}
