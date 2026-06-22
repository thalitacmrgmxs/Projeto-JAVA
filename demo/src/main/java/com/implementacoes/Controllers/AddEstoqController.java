/*Classe criada para Adicionar novos produtos ao estoque */


//Pacote Correspondente
package com.implementacoes.Controllers;

//importações
import java.io.IOException;

import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Sua respectiva classe
public class AddEstoqController {
    public AddEstoqController() {

    }
    //Abaixo estão as variaveis FXML
    @FXML
    private TextField NomeField;

    @FXML
    private TextField QuantiField;

    @FXML
    private TextField ValorField;

    //método FXML que é ativado quando o botão COnfirmar é apertado 
    @FXML
    void Confirmar(ActionEvent event) {
        //Variaveis auxiliares
        boolean encontrou = false;
        Produtos produto = (new Produtos(NomeField.getText(),Double.parseDouble(ValorField.getText()), Double.parseDouble(QuantiField.getText()), DonoController.dono.getNomeEmpreendimento()));
       
        
        //Verificar se existe o produto na lista
        for (int i = 0; i < Gerenciador.getListaEstoque().size(); i++) {
            //Condição que verificar um correspondente
            if (produto.getNome().equalsIgnoreCase(Gerenciador.getListaEstoque().get(i).getNome())) {
                Gerenciador.getListaEstoque().get(i).setQuant(Gerenciador.getListaEstoque().get(i).getQuant()+ produto.getQuant());
                encontrou = true;   //Se houver, atribuir um true ao boolean
                break;  //e quebramos o loop para evitar pecorrer a lista sem necessidade
                
            }
        }
        //Se não encontrou execute esse comando
        if (!encontrou) {
            Gerenciador.getListaEstoque().add(produto); //Adicionou o novo produto a lista
        }

        //Limpamos os textfields para ficar chique
        NomeField.clear();
        ValorField.clear();
        QuantiField.clear();

    }

    //Método criado para inicializar um novo Stage(Palco) e uma nova Scene(Cena)
    public void Start() {
        //Adicionamos um try_catch ou seja tratamento de erros e exções 
        try {
            //1. carregar o fxml -- Foi necessario fazer a rota a partir do APP
            java.net.URL fxmlUrl = com.implementacoes.App.class.getResource("/com/implementacoes/AddEstoq.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlUrl); //Criamos um Fxmlloader
            Parent root = loader.load(); // carregamos o arquivo

            //2. Criar uma nova cena com o layout fxml
            Scene CenaAddEstoq = new Scene(root);   //o root serve como a raiz do tree-graph

            //3.Criar um novo palco
            Stage JanelaAddEstoq = new Stage(); // criamos o objeto Stage
            JanelaAddEstoq.setTitle("Adicionar Produto"); //Titulo do Stage
            JanelaAddEstoq.setScene(CenaAddEstoq); // Atribuimos a cena

            //4.exibir
            JanelaAddEstoq.show(); //hora do show....ksksks
            
        } catch (IOException ex ) { //o ioException é obrigatorio para p funcionamento do programa
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }


    }

}
