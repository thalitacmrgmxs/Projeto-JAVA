/* janela para edição dos produtos no estoque */
package com.implementacoes.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.implementacoes.Objetos.Empreendedor;
import com.implementacoes.Objetos.Gerenciador;
import com.implementacoes.Objetos.Produtos;
import com.implementacoes.Objetos.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EdiDeltProdutos implements Initializable {
    
    private Usuario user; // Armazena Empreendedor ou Funcionario

    @FXML
    private ChoiceBox<Produtos> OpcoesProdMenu;

    @FXML
    private TextField produtoNome;

    @FXML
    private TextField produtoQuant;

    @FXML
    private TextField produtoValor;

    @FXML
    void Editar(ActionEvent event) {
        Produtos produtoSel = OpcoesProdMenu.getValue();

        // Evita erros se o usuário clicar em Editar sem selecionar nenhum produto
        if (produtoSel == null) {
            return; 
        }

        // Altera as propriedades do produto selecionado
        produtoSel.setNome(produtoNome.getText());
        produtoSel.setQuant(Double.parseDouble(produtoQuant.getText()));
        produtoSel.setValor(Double.parseDouble(produtoValor.getText()));

        int index = Gerenciador.getListaEstoque().indexOf(produtoSel);
        int indexT = DonoController.listaTemporariaE.indexOf(produtoSel);

        // Se a quantidade for menor ou igual a zero, remove de vez
        if (produtoSel.getQuant() <= 0) {   
            if (index != -1) {
                Gerenciador.getListaEstoque().remove(index);
            }
            
            if (indexT != -1) {
                DonoController.listaTemporariaE.remove(indexT);
            }
            
            OpcoesProdMenu.getSelectionModel().clearSelection(); 
        } else {    
            // Se não, atualiza a posição nas listas
            if (index != -1) {
                Gerenciador.getListaEstoque().set(index, produtoSel);}
            
            if (indexT != -1) {
                DonoController.listaTemporariaE.set(indexT, produtoSel);
            }
        }

        // Limpa os campos de texto
        produtoNome.clear();
        produtoQuant.clear();
        produtoValor.clear();

        
    }

    // Corrigido para ler o parâmetro enviado pelo listener (evita buscas repetidas na ChoiceBox)
    private void PrencherLacunas(Produtos produto) {
        if (produto != null) {
            produtoNome.setText(produto.getNome());
            produtoQuant.setText(String.valueOf(produto.getQuant()));
            produtoValor.setText(String.valueOf(produto.getValor()));
        }
    }

    // Método para iniciar a janela (Padrão de troca de dados do JavaFX)
    public void start(Usuario user) {
        try {
            java.net.URL fxmUrl = com.implementacoes.App.class.getResource("/com/implementacoes/Del_edit_produtos.fxml");
            FXMLLoader loader = new FXMLLoader(fxmUrl);
            Parent root = loader.load();

            // CAPTURA O CONTROLLER REAL CRIADO PELO FXML
            EdiDeltProdutos controllerReal = loader.getController();
            
            // Injeta o usuário na instância real da tela e preenche o menu
            controllerReal.initUsuario(user);

            Scene cenaDelEditProdutos = new Scene(root);
            Stage JanelaDelEditProdutos = new Stage();
            JanelaDelEditProdutos.setTitle("Editar Produtos");
            JanelaDelEditProdutos.setScene(cenaDelEditProdutos);           
            JanelaDelEditProdutos.show();

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho.");
        }
    }

    // Método auxiliar executado LOGO APÓS a tela abrir para injetar o usuário com segurança
    public void initUsuario(Usuario user) {
        this.user = user;
        
        // verificamos se o usuario é empreendedor
        if (user instanceof Empreendedor) {
            OpcoesProdMenu.setItems(DonoController.listaTemporariaE);
            //OpcoesProdMenu.setItems(Gerenciador.preencherE(DonoController.dono.getNome()));
        } else {
            //OpcoesProdMenu.setItems(DonoController.listaTemporariaE);
            OpcoesProdMenu.setItems(Gerenciador.preencherE(EstoquistaJanController.funcSel.getChefe()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // O "user" ainda está nulo aqui, por isso removemos a verificação dele daqui.
        
        // Mantemos apenas o Listener que monitora a seleção do menu em tempo real
        OpcoesProdMenu.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, produtoSelecionado) -> {
                    PrencherLacunas(produtoSelecionado);
                });
    }
}