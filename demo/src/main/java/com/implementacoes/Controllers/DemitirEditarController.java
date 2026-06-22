/* Classe criada para Demitir funcionarios,
ou seja, elimina-los da lista */

//Pacote correspondente
package com.implementacoes.Controllers;
//importações
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.implementacoes.Objetos.Funcionario;
import com.implementacoes.Objetos.Gerenciador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Classe correspondnete
public class DemitirEditarController implements Initializable {
    //variaveis
    protected Funcionario FuncionarioSele; //Protected para ser acessivel á todos do pacote
    //variaveis FXML
    @FXML
    private DatePicker FuncAdmissao;

    @FXML
    private TextField FuncFuncao;

    @FXML
    private TextField FuncNome;

    @FXML
    private ChoiceBox<Funcionario> FuncOpcoesMenu;

    @FXML
    private TextField FuncSalario;

    @FXML
    private TextField FuncTarefas;

    //Método ativado por um ActionEvent para remover o funcionario selecionado
    @FXML
    void Demitir(ActionEvent event) {
        Gerenciador.getListaFuncionarios().remove(FuncionarioSele);
    }

    //método para editar as informações do Funcionario
    @FXML
    void Edit(ActionEvent event) {
    // 1. Pega o funcionário diretamente da ChoiceBox
    FuncionarioSele = FuncOpcoesMenu.getValue();

    if (FuncionarioSele != null) {
        // 2. Atualiza os dados do objeto na memória
        FuncionarioSele.setNome(FuncNome.getText());
        FuncionarioSele.setCargo(FuncFuncao.getText());
        FuncionarioSele.setData_de_admissao(FuncAdmissao.getValue());
        FuncionarioSele.setSalario(Float.parseFloat(FuncSalario.getText()));

        // 3. Força a ChoiceBox e a tela a atualizarem visualmente
        int index = Gerenciador.getListaFuncionarios().indexOf(FuncionarioSele);
        Gerenciador.getListaFuncionarios().set(index, FuncionarioSele);
        
        System.out.println("Funcionário editado com sucesso!"); //msg para teste
    } else {
        System.out.println("Nenhum funcionário selecionado para editar.");  //msg para teste
    }
}


    
    //Inicializar a janela e o palco
    public void start() {
        //Adicionamos um try_catch ou seja tratamento de erros e exções 
        try {
        //1. carrega o fxml
        java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/Demitir_editar_funcionario.fxml");
        FXMLLoader loader = new FXMLLoader((fxmUrl)); //Criando o FXMLLOADER
        Parent root = loader.load();    //Carregando a cena dentro do root

        //Criar a cena
        Scene cenaDemitirEditar = new Scene(root); //atribuimos o root á cena

        //Criando a janela
        Stage JanelaDemitirEditar = new Stage();
        JanelaDemitirEditar.setScene(cenaDemitirEditar);  //atribuindo a cena á janela
        JanelaDemitirEditar.setTitle("Demitir e Editar");   //atribuindo o titulo
        
        //mostrando
        JanelaDemitirEditar.show(); //hora do show..ksskks
        
        }catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

    //Inicializando as variaveis da janela
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //1 Vincula a lista de funcionarios ao choicebox
        FuncOpcoesMenu.setItems(Gerenciador.getListaFuncionarios());
        
        //OBSERVAÇÂO: Talvez eu possa mudar o código abaixo para diminuir o código
        //Adicionando um Ouvinte aos items para observar a escolha no momento
        FuncOpcoesMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, FuncionarioSelecionado) -> {
            if (FuncionarioSelecionado != null) {
                preencherCampos(FuncionarioSelecionado);    //método criado para preencherCampos
                FuncionarioSele = FuncionarioSelecionado;   //Atribuindo á variavel funcionarioSele
            }
        });
    }

    // 3. Método auxiliar para preencher todos os campos da tela
    private void preencherCampos(Funcionario funcionario) {
        FuncNome.setText(funcionario.getNome());
        FuncFuncao.setText(funcionario.getCargo());
        FuncSalario.setText(String.valueOf(funcionario.getSalario()));
        FuncAdmissao.setValue(funcionario.getData_de_admissao());
        
    }
}
