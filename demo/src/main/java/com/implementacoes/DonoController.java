package com.implementacoes; //formatado


import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class DonoController implements Initializable {
    //variaveis
    private Empreendedor dono = Gerenciador.getSelecionado();

    public DonoController(Empreendedor dono) {
        this.dono = dono;
    }

    public DonoController() {
        this.dono = Gerenciador.getSelecionado();
    }

    //Objetos fxml
    @FXML
    private TableView<Produtos> EstoqueTable;

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

        //criando a lista e inserindo os produtos
        ObservableList<Produtos> lista = FXCollections.observableArrayList(
            new Produtos("ração", 20, 2)
        );

        //inserindo na tabela
        EstoqueTable.setItems(lista);
    }
    //Criar um método para preencher a tabela de funcionarios
    private void preencherFuncionariosTable() {
        //determinado o valor correspondete a cada coluna
        NomeFuncColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        FuncaoFuncColumn.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        taskFuncColumn1.setCellValueFactory(new PropertyValueFactory<>("tarefas_Atuais"));
        
        //criando a lista e inserindo os funcionarios
        ObservableList<Funcionario> lista = FXCollections.observableArrayList(
            new Funcionario("ester", "123", "email", 2000, "motoboy", 12, 5),
            new Funcionario("Felipe", "554", "email", 2000, "vendedor", 12, 10)
            
        );
        //inserindo na tabela 
        FuncionariosTable.setItems(lista);
    }


    //Inicializar as variaveis presentes no GUI
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       TextNome.setText(dono.getNome());
       nameShop.setText(dono.getNomeEmpreendimento());
       TextEmpreendedor.setText(String.valueOf(dono.getId_empresa()));
     

       if (dono.getNome().equalsIgnoreCase("Thalita")) {
            preencherFuncionariosTable();
            preencherEstoqueTable();

    }

   
    
}}
 
