
package com.implementacoes.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

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
    void AddGasolina(ActionEvent event) {

    }

    @FXML
    void MinusGasolina(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

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
