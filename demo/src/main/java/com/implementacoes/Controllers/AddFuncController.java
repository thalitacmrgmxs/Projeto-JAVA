/*Classe criada para adicionar novos Funcionarios */


//Pacote Correspondente
package com.implementacoes.Controllers;

//importações
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Sua respectiva classe
public class AddFuncController implements Initializable {
    //Construtor vazio
    public AddFuncController() {

    }
    
    //FXMLS
     @FXML
    private TextField FuncEmail;

    @FXML
    private DatePicker funcAdmissao;

    @FXML
    private ChoiceBox<String> funcCargo;

    @FXML
    private TextField funcNome;

    @FXML
    private TextField funcSalario;

    @FXML
    private TextField funcSenha;

    //método chamado pelo ActionEvent do botão, a qual ele adicionar um novo funcionario
    @FXML
    void Confirmar(ActionEvent event) {
        Gerenciador.listaFuncionarios.add(new Funcionario(funcNome.getText(), funcSenha.getText(), FuncEmail.getText(), Float.parseFloat(funcSalario.getText()), funcCargo.getValue() , funcAdmissao.getValue()));
    }

    //método para inicializar o palco e a cena correspondente
    public void start() {
        ///Adicionamos um try_catch ou seja tratamento de erros e exções 
        try {
            // 1. carrega o fxml
            java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/AddFuncionario.fxml");
            FXMLLoader loader = new FXMLLoader((fxmUrl)); //Criando o FXMLLoader
            Parent root = loader.load();    //Criando o root, a raiz do tree graph

            // 2.criar nova cena com layout carregado fxml
            Scene CenaADDFormulario = new Scene(root);  //atribuindo o root á scene

            // 3. criar um novo palco
            Stage JanelaAddFuncionario = new Stage();   //Criando o Stage, janela
            JanelaAddFuncionario.setTitle("Adicionar Funcionario"); //titulo do Stage, janela
            JanelaAddFuncionario.setScene(CenaADDFormulario); //Atribuindo a cena ao Stage

            // 4. exibi a janela
            JanelaAddFuncionario.show();    //hora do show...ksks

            // Captura de erro
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

    //inicialização, chamado quando seu root é carregado
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] opcoes = {"Estoquista", "Atendente", "Entregador"}; //atribuindo as opções ao novo Funcionario
        

        // Popular o ChoiceBox de forma otimizada
        funcCargo.setItems(FXCollections.observableArrayList(opcoes)); //adicinamos a opção ao choiceBox
        
    }
    



}



    

