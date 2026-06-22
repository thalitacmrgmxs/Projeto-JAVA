/*Essa clase é responsavel por controlar a janela do Empreendedor,
a qual ele acessa outras janelas e métodos de outras classes para
executar determinada ações:
1. Gerenciador;
2. EdiDeltProdutos;
3. DemitirEditarController;
4.AddEstoqController;
5.AddFuncController 
*/


//pacote
package com.implementacoes.Controllers; 

//Importações
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.implementacoes.App;
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

//sua classe correspondente
public class DonoController implements Initializable {
    //variaveis
    private Empreendedor dono = Gerenciador.getSelecionado();   //Ele chama o objeto Empreendedor que está contifo no Gerenciador.getSelecionado
       //A lista de Produdots é distribuida para as outras classes dentro do pacote
    
    //há dois contrutores, um que recebe o empreendedor
    public DonoController(Empreendedor dono) {
        this.dono = dono;
    }
    //Outro que recebe do Gerenciador
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

    //Eliminar/Editar produto do estoque chamado quando o botão é clicado
    @FXML
    void minusEstoque(ActionEvent event) {
         System.out.println("eliminar Estoque");    //msg para testes
         EdiDeltProdutos EdiDeltProdutosFormulario = new EdiDeltProdutos(); //Criamos o objeto do EdiDeltProdutos
         EdiDeltProdutosFormulario.start(); //Chamamos o método para iniciar a janela
        
    }

    //Demitir funcionario chamado quando o botão é clicado
    @FXML
    void minusFuncionarios(ActionEvent event) {
        
         System.out.println("eliminar funcionario"); // msg para teste
         DemitirEditarController DemEdFormulurario = new DemitirEditarController(); //Criamos o objeto do  DemitirEditarController
         DemEdFormulurario.start(); //Chamamos o método para iniciar a janela
    }

    //Adicionar Estoque chamado quando o botão é clicado
    @FXML
    void plusEstoque(ActionEvent event) {
        System.out.println("adicionar Estoque");    //msg para teste
        AddEstoqController EstoqFormulario = new AddEstoqController();  //criando o objeto do AddEstoqController
        EstoqFormulario.Start();    //chamamos o método para iniciar a janela
        
    }
    //adicionar mais um funcionario
    @FXML
    void plusFuncionarios(ActionEvent event) {
     //chamado o controller responsavel por capturar as interações na proxima tela
     AddFuncController Funcformulario = new AddFuncController(); //criando o objeto AddFuncController 
     Funcformulario.start();    //chamamos o método para iniciar a janela
    } 
    
    //voltar para a janela anterior
    @FXML
    void Voltar(ActionEvent event) {
        // Tratamento de erro e exceção try_catch
        try {
            App.setRoot("Login");   //mudando a cena
            Gerenciador.setListaEstoque(FXCollections.observableArrayList()); //resetando a lista
            Gerenciador.setListaFuncionarios(FXCollections.observableArrayList()); //resetando a lista
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }
    //métodos -- EM ANÁLISE da eficiẽncia desses métodos
    public Empreendedor getDono() {
        return dono;    //Retornar o dono
    }

    public void setDono(Empreendedor dono) {
        this.dono = dono;   //determinar o dono
    }

    //Criar um função para preencher o estoque
    private void preencherEstoqueTable() {
        // determinando o valor correspondente de cada coluna
        produtosColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        QuantColumn.setCellValueFactory(new PropertyValueFactory<>("quant"));

        //caso especial de thalita
        if (dono.getNome().equalsIgnoreCase("Thalita")) {
            // criando a lista e inserindo os produtos
            Gerenciador.getListaEstoque().add(new Produtos("ração", 20, 2));
        }
        // inserindo na tabela
        EstoqueTable.setItems(Gerenciador.getListaEstoque());
    }
    //Criar um método para preencher a tabela de funcionarios
    private void preencherFuncionariosTable() {
        // determinado o valor correspondete a cada coluna
        NomeFuncColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        FuncaoFuncColumn.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        taskFuncColumn1.setCellValueFactory(new PropertyValueFactory<>("tarefas_Atuais"));
        
        //Caso especial thalita
        if (dono.getNome().equalsIgnoreCase("Thalita")) {
            Gerenciador.getListaFuncionarios().add(new Funcionario("ester", "123", "email", 2000, "motoboy", LocalDate.of(2000, 12, 2)));
            Gerenciador.getListaFuncionarios().addAll(
                    new Funcionario("Felipe", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2)),
                    new Funcionario("Maria", "554", "email", 2000, "vendedor", LocalDate.of(2000, 12, 2)));
        }
        // inserindo na tabela
        FuncionariosTable.setItems(Gerenciador.getListaFuncionarios());
    }


    //Inicializar as variaveis presentes no GUI
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //preencher as variaveis
       TextNome.setText(dono.getNome());
       nameShop.setText(dono.getNomeEmpreendimento());
       TextEmpreendedor.setText(String.valueOf(dono.getId_empresa()));
       //preencher as tableas
       preencherFuncionariosTable();   
       preencherEstoqueTable();
}}
 
