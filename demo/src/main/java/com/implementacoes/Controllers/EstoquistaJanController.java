package com.implementacoes.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.App;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class EstoquistaJanController implements Initializable {

    
    protected static Funcionario funcSel = new Funcionario(null, null, null, 0, null, null);
    protected static ObservableList<Produtos> listaTemporaria;
    public EstoquistaJanController() {
        funcSel = (Funcionario) Gerenciador.getSelecionado();
    }

     public Funcionario getFuncSel() {
        return funcSel;
    }

    public void setFuncSel(Funcionario funcSelT) {
        funcSel = funcSelT;
    }
    @FXML
    private Text FuncFuncao;

    @FXML
    private Text TituloFunc;

    @FXML
    private Text FuncNome;

    @FXML
    private Text FuncSalario;

    @FXML
    private TableColumn<Produtos, String> NomeColumnEst;

    @FXML
    private TableColumn<Produtos, Double> QuantColumnEst;

    @FXML
    private TableView<Produtos> TableEstoqueProd;

    @FXML
    private TableColumn<Produtos, String> TaksColumn;

    @FXML
    private TableView<?> TaskTable;

    @FXML
    private TableColumn<Produtos, Double> ValorColumnEst;

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

    @FXML
    void minusEstoque(ActionEvent event) {
        EdiDeltProdutos JanEditDEl = new EdiDeltProdutos();
        JanEditDEl.start(funcSel);
    }

    @FXML
    void plusEstoque(ActionEvent event) {
        System.out.println("adicionar Estoque");    //msg para teste
        AddEstoqController EstoqFormulario = new AddEstoqController();  //criando o objeto do AddEstoqController
        EstoqFormulario.Start(funcSel);    //chamamos o método para iniciar a janela
    }

    public void preencheTabela() {
        NomeColumnEst.setCellValueFactory(new PropertyValueFactory<>("nome"));
        QuantColumnEst.setCellValueFactory(new PropertyValueFactory<>("quant"));
        ValorColumnEst.setCellValueFactory(new PropertyValueFactory<>("valor"));

        listaTemporaria = Gerenciador.preencherE(funcSel.getChefe());
        TableEstoqueProd.setItems(listaTemporaria);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Incializando
        TituloFunc.setText("Bem vindo, " + funcSel.getNome());
        FuncNome.setText(FuncNome.getText() + funcSel.getNome());
        FuncFuncao.setText(FuncFuncao.getText() + funcSel.getCargo());
        FuncSalario.setText(FuncSalario.getText() + String.valueOf(funcSel.getSalario()));

        //preencher a tabela
        preencheTabela();
        
    }



}
