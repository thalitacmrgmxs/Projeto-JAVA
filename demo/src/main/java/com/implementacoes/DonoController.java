package com.implementacoes; //formatado


import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    //métodos -- EM ANÁLISE da eficiẽncia desses métodos
    public Empreendedor getDono() {
        return dono;    //Retornar o dono
    }

    public void setDono(Empreendedor dono) {
        this.dono = dono;   //determinar o dono
    }

    //Inicializar as variaveis presentes no GUI
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       TextNome.setText(dono.getNome());
       
    }

   
    
}
 
