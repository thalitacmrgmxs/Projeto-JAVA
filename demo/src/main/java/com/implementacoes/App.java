/*Este arquivo java representa o App que possue a classe main, sendo o responsavel por
rodar o sistema inteiro
 através dele como canal. */

//Pacote Correspondente
package com.implementacoes;

//importações
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.implementacoes.Objetos.Gerenciador;

//Classe publica do APP
public class App extends Application {
    //variaveis
    private static Scene scene; //Variavel estatica,acessivel a todos, sendo a Scene
    

    //método do javafx para iniciar o palco
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login")); //Atribuindo um arquivo FXML a scene
        stage.setScene(scene);  //atribuindo ao Stage, palco, uma cena
        stage.show(); //Mostrar o Stage que é o mesmo de uma janela
    }
    //determinar a rota do fxml
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml)); //Esse método é perfeito para muda a scene do palco principal
    }
    //método responsavel por carregar o fxml
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")); //Criamos um Loader que carregar o arquivo
        return fxmlLoader.load(); //Carregamos o arquivo
    }

    //método principal do programa
    public static void main(String[] args) {
        launch(); //lançamento do sistema
        
    
        

    }

   

 

}