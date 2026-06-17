package com.implementacoes;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class DonoController {
    //Gerenciador 
    @FXML
    private TableView<?> EstoqueTable;

    @FXML
    private TableView<?> EstoqueTable1;

    @FXML
    private TableColumn<?, ?> FuncaoFuncColumn;

    @FXML
    private TableColumn<?, ?> NomeFuncColumn;

    @FXML
    private TableColumn<?, ?> QuantColumn;

    @FXML
    private Text TextCompras;

    @FXML
    private Text TextEmpreendedor;

    @FXML
    private Text TextNome;

    @FXML
    private Text TextSituacao;

    @FXML
    private Text TextTasks;

    @FXML
    private Text TextVendas;

    @FXML
    private Text nameShop;

    @FXML
    private TableColumn<?, ?> produtosColumn;

    @FXML
    private TableColumn<?, ?> taskFuncColumn1;

}
