package com.implementacoes.Controllers; //formatado


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DonoController implements Initializable {
    //variaveis
    private Empreendedor dono = Gerenciador.getSelecionado();
    protected static ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    protected static ObservableList<Produtos> listaEstoque = FXCollections.observableArrayList();
   
    public DonoController(Empreendedor dono) {
        this.dono = dono;
    }

    public DonoController() {
        this.dono = Gerenciador.getSelecionado();
    }

    //Objetos fxml
   @FXML 
   protected TableView<Produtos> EstoqueTable;
   
   
   

    @FXML
    private TableView<Funcionario> FuncionariosTable;
    @FXML
    private TableColumn<Funcionario, String> FuncaoFuncColumn;

    @FXML
    private TableColumn<Funcionario, String> NomeFuncColumn;

    @FXML
    private TableColumn<Produtos, Double> QuantColumn;
    
    @FXML
    private TableColumn<Produtos, String> produtosColumn;

    @FXML
    private TableColumn<Funcionario, String> taskFuncColumn1;
    
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
    void minusEstoque(ActionEvent event) {
         System.out.println("eliminar Estoque");
         EdiDeltProdutos EdiDeltProdutosFormulario = new EdiDeltProdutos();
         EdiDeltProdutosFormulario.start();
        
    }

    //Demitir funcionario
    @FXML
    void minusFuncionarios(ActionEvent event) {
         System.out.println("eliminar funcionario");
         DemitirEditarController DemEdFormulurario = new DemitirEditarController();
         DemEdFormulurario.start();
    }

    //Adicionar Estoque
    @FXML
    void plusEstoque(ActionEvent event) {
        System.out.println("adicionar Estoque");
        AddEstoqController EstoqFormulario = new AddEstoqController();
        EstoqFormulario.Start();
        
    }
    //adicionar mais um funcionario
    @FXML
    void plusFuncionarios(ActionEvent event) {
     //chamado o controller responsavel por capturar as interações na proxima tela EM ANALISE
     AddFuncController Funcformulario = new AddFuncController();
     Funcformulario.start();
    } 

    //__________________________

    //métodos -- EM ANÁLISE da eficiẽncia desses métodos
    public Empreendedor getDono() {
        return dono;    //Retornar o dono
    }

    public void setDono(Empreendedor dono) {
        this.dono = dono;   //determinar o dono
    }

    //Criar um função para preencher o estoque
    private void preencherEstoqueTable() {
        //determinando o valor correspondente de cada coluna
        produtosColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        QuantColumn.setCellValueFactory(new PropertyValueFactory<>("quant"));

        if (dono.getNome().equalsIgnoreCase("Thalita")) {
        //criando a lista e inserindo os produtos
        listaEstoque.add(new Produtos("ração", 20, 2));
        }
        //inserindo na tabela
        EstoqueTable.setItems(listaEstoque);
    }
    //Criar um método para preencher a tabela de funcionarios
    private void preencherFuncionariosTable() {
        //determinado o valor correspondete a cada coluna
        NomeFuncColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        FuncaoFuncColumn.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        taskFuncColumn1.setCellValueFactory(new PropertyValueFactory<>("tarefas_Atuais"));
        
        if (dono.getNome().equalsIgnoreCase("Thalita")) {
            listaFuncionarios.add(new Funcionario("ester", "123", "email", 2000, "motoboy", LocalDate.of(2000, 12, 2)));
            listaFuncionarios.addAll( new Funcionario("Felipe", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2)),
             new Funcionario("Felipe", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2)));
        }
            //inserindo na tabela 
        FuncionariosTable.setItems(listaFuncionarios);
    }


    //Inicializar as variaveis presentes no GUI
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       TextNome.setText(dono.getNome());
       nameShop.setText(dono.getNomeEmpreendimento());
       TextEmpreendedor.setText(String.valueOf(dono.getId_empresa()));
       preencherFuncionariosTable();
       preencherEstoqueTable();

    

   
    
}}
 
