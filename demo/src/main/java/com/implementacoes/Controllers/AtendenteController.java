package com.implementacoes.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Atendente;
import com.implementacoes.Objetos.Entregador;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AtendenteController implements Initializable {
    protected static Atendente funcSel = new Atendente(null, null, null, 0, null, null, null);
    private Produtos produtoSel;
    private float valorProdTot = 0;
    private int quantProdTot = 0;
    public AtendenteController(){
        funcSel = (Atendente) Gerenciador.getSelecionado();
    }
        @FXML
    private Text FuncFuncao;

    @FXML
    private Text FuncNome;

    @FXML
    private Text FuncSalario;

    @FXML
    private Text FuncSalario11;

    @FXML
    private ChoiceBox<Produtos> OpcoesProduto;

    @FXML
    private Text ProdutoNome;

    @FXML
    private Text ProdutoValor;

    @FXML
    private Text QuantTotal;

    @FXML
    private TableColumn<?, ?> TaksColumn;

    @FXML
    private TableView<?> TaskTable;

    @FXML
    private Text TituloFunc;

    @FXML
    private Text TituloFunc1;

    @FXML
    private Text TotalText;

    @FXML
    private TextField quantArea;

    @FXML
    void MinusItem(ActionEvent event) {
        
        valorProdTot -= Integer.parseInt(quantArea.getText())*produtoSel.getValor();
        quantProdTot -= Integer.parseInt(quantArea.getText());
        TotalText.setText("Total: " + String.valueOf(valorProdTot));
        QuantTotal.setText("Quantidade total: " + String.valueOf(quantProdTot));

        
    }
    

    @FXML
    void plusItem(ActionEvent event) {
        if (quantArea.getText() != "") {
        valorProdTot += Integer.parseInt(quantArea.getText())*produtoSel.getValor();
        quantProdTot += Integer.parseInt(quantArea.getText());
        TotalText.setText("Total: " + String.valueOf(valorProdTot));
        QuantTotal.setText("Quantidade total: " + String.valueOf(quantProdTot));
    }
    }

    @FXML
    void voltar(ActionEvent event) {

    }


    private void PrencherLacunas(Produtos produto) {
        produtoSel = produto;
        if (produto != null) {
            ProdutoNome.setText("Produto: "+produto.getNome());
            ProdutoValor.setText("Valor: "+String.valueOf(produto.getValor()));
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Incializando
        TituloFunc.setText("Bem vindo, " + funcSel.getNome());
        FuncNome.setText(FuncNome.getText() + funcSel.getNome());
        FuncFuncao.setText(FuncFuncao.getText() + funcSel.getCargo());
        FuncSalario.setText(FuncSalario.getText() + String.valueOf(funcSel.getSalario()));
        
        //Acionando as opções
        OpcoesProduto.setItems(Gerenciador.preencherE(AtendenteController.funcSel.getChefe()));

        //adicionando o ouvido
        OpcoesProduto.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, produtoSelecionado) -> {
                    PrencherLacunas(produtoSelecionado);
                });
    }

}
