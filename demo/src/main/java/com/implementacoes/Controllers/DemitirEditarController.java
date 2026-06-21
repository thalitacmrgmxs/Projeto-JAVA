package com.implementacoes.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Funcionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DemitirEditarController implements Initializable {
    //variaveis
    protected Funcionario FuncionarioSele; 
     @FXML
    void Demitir(ActionEvent event) {
        DonoController.listaFuncionarios.remove(FuncionarioSele);
    }

    @FXML
    void Edit(ActionEvent event) {
        
    }

    @FXML
    private TextField FuncAdmissao;

    @FXML
    private TextField FuncFuncao;

    @FXML
    private TextField FuncNome;

    @FXML
    private ChoiceBox<Funcionario> FuncOpcoesMenu;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //1 Vincula a lista de funcionarios ao choicebox
        FuncOpcoesMenu.setItems(DonoController.listaFuncionarios);
        
         FuncOpcoesMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, FuncionarioSelecionado) -> {
            if (FuncionarioSelecionado != null) {
                preencherCampos(FuncionarioSelecionado);
                FuncionarioSele = FuncionarioSelecionado;
            }
        });
    }

    // 3. Método auxiliar para preencher todos os campos da tela
    private void preencherCampos(Funcionario funcionario) {
        FuncNome.setText(funcionario.getNome());
        FuncFuncao.setText(funcionario.getCargo());
        FuncSalario.setText(String.valueOf(funcionario.getSalario()));
        FuncAdmissao.setText(String.valueOf(funcionario.getData_de_admissao())); // Adapte se for tipo Date
              // Adapte se for uma lista
    }
}
