/*Classe criada para gerenciar a janella do entregador, a qual
ele informar a quantidade de gasolina gasta. */
package com.implementacoes.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.App;
import com.implementacoes.Objetos.Entregador;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EntregadorController implements Initializable{

    protected static Entregador funcSel = new Entregador(null, null, null, 0, null, null, null, 0);
    protected static ObservableList<Produtos> listaTemporaria;
   
    public EntregadorController() {
        funcSel = (Entregador) Gerenciador.getSelecionado();
    }
    @FXML
    private Text FuncFuncao;

    @FXML
    private Text FuncNome;

    @FXML
    private Text FuncSalario;

    @FXML
    private Text GasAtualText;

    @FXML
    private Text GasGastaText;

    @FXML
    private TableColumn<?, ?> TaksColumn;

    @FXML
    private TableView<?> TaskTable;

    @FXML
    private Text TituloFunc;

    @FXML
    private TextField quantArea;

    @FXML
    void AddGasolina(ActionEvent event) {
        funcSel.setGasolina_atual(Integer.parseInt(quantArea.getText()));
        //atualizar
         GasAtualText.setText("Gasolina atual: "+ String.valueOf(funcSel.getGasolina_atual()));
         GasGastaText.setText("Gasolina Gasta: " + String.valueOf(funcSel.getGasolina_gasta()));
    }

    @FXML
    void MinusGasolina(ActionEvent event) {
        funcSel.setGasolina_atual(-1*Integer.parseInt(quantArea.getText()));
        //atualizar
        GasAtualText.setText("Gasolina atual: "+ String.valueOf(funcSel.getGasolina_atual()));
        GasGastaText.setText("Gasolina Gasta: " + String.valueOf(funcSel.getGasolina_gasta()));
        }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Incializando
        TituloFunc.setText("Bem vindo, " + funcSel.getNome());
        FuncNome.setText(FuncNome.getText() + funcSel.getNome());
        FuncFuncao.setText(FuncFuncao.getText() + funcSel.getCargo());
        FuncSalario.setText(FuncSalario.getText() + String.valueOf(funcSel.getSalario()));
        GasAtualText.setText(GasAtualText.getText() + String.valueOf(funcSel.getGasolina_atual()));
        GasGastaText.setText(GasGastaText.getText() + String.valueOf(funcSel.getGasolina_gasta()));
    }

}
