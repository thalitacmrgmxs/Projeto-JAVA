package com.implementacoes.Controllers;

import java.io.IOException;
import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;
import com.implementacoes.Objetos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEstoqController {
    
    public AddEstoqController() {}

    private Usuario user; 

    @FXML
    private TextField NomeField;

    @FXML
    private TextField QuantiField;

    @FXML
    private TextField ValorField;

    @FXML
    void Confirmar(ActionEvent event) {
        // Validação básica para evitar campos em branco quebrando o parseDouble
        if (NomeField.getText().isEmpty() || ValorField.getText().isEmpty() || QuantiField.getText().isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        boolean encontrou = false;
        
        // ---- BLOCO 1: SE FOR EMPREENDEDOR ----
        if (user instanceof Empreendedor empreendedor) {
            // Buscamos o nome do empreendimento direto do objeto 'empreendedor' injetado de forma segura!
            Produtos produto = new Produtos(NomeField.getText(), Double.parseDouble(ValorField.getText()), Double.parseDouble(QuantiField.getText()), empreendedor.getNomeEmpreendimento());
            
            for (int i = 0; i < Gerenciador.getListaEstoque().size(); i++) {
                if (produto.getNome().equalsIgnoreCase(Gerenciador.getListaEstoque().get(i).getNome())) {
                    Gerenciador.getListaEstoque().get(i).setQuant(Gerenciador.getListaEstoque().get(i).getQuant() + produto.getQuant());
                    
                    Produtos produtoExistente = Gerenciador.getListaEstoque().get(i);
                    int index = DonoController.listaTemporariaE.indexOf(produtoExistente);
                    
                    if (index != -1) {
                        DonoController.listaTemporariaE.get(index).setQuant(DonoController.listaTemporariaE.get(index).getQuant() + produto.getQuant());
                    }
                    encontrou = true;   
                    break;  
                }
            }
            if (!encontrou) {
                Gerenciador.getListaEstoque().add(produto); 
                DonoController.listaTemporariaE.add(produto); 
            }

        // ---- BLOCO 2: SE FOR FUNCIONÁRIO (ESTOQUISTA) ----
        } else {
            // Buscamos o chefe/empreendimento cadastrado na janela do Estoquista de forma segura
            String empresaDoChefe = (EstoquistaJanController.funcSel != null) ? EstoquistaJanController.funcSel.getChefe() : "Geral";
            Produtos produto = new Produtos(NomeField.getText(), Double.parseDouble(ValorField.getText()), Double.parseDouble(QuantiField.getText()), empresaDoChefe);
            
            for (int i = 0; i < Gerenciador.getListaEstoque().size(); i++) {
                if (produto.getNome().equalsIgnoreCase(Gerenciador.getListaEstoque().get(i).getNome())) {
                    Gerenciador.getListaEstoque().get(i).setQuant(Gerenciador.getListaEstoque().get(i).getQuant() + produto.getQuant());
                    
                    Produtos produtoExistente = Gerenciador.getListaEstoque().get(i);
                    int index = EstoquistaJanController.listaTemporaria.indexOf(produtoExistente);
                    
                    if (index != -1) {
                        EstoquistaJanController.listaTemporaria.get(index).setQuant(EstoquistaJanController.listaTemporaria.get(index).getQuant() + produto.getQuant());
                    }
                    encontrou = true;   
                    break;  
                }
            }
            if (!encontrou) {
                Gerenciador.getListaEstoque().add(produto); 
                EstoquistaJanController.listaTemporaria.add(produto); 
            }
        }

        // Limpamos os textfields para ficar chique
        NomeField.clear();
        ValorField.clear();
        QuantiField.clear();
    }

    public void initUsuario(Usuario user) {
        this.user = user;
    }

    public void Start(Usuario user) {
        try {
            java.net.URL fxmlUrl = com.implementacoes.App.class.getResource("/com/implementacoes/AddEstoq.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlUrl); 
            Parent root = loader.load(); 

            AddEstoqController controllReal = loader.getController();
            controllReal.initUsuario(user);
            
            Scene CenaAddEstoq = new Scene(root);   
            Stage JanelaAddEstoq = new Stage(); 
            JanelaAddEstoq.setTitle("Adicionar Produto"); 
            JanelaAddEstoq.setScene(CenaAddEstoq); 
            JanelaAddEstoq.show(); 
            
        } catch (IOException ex ) { 
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }
}