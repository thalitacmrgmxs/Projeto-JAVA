module com.implementacoes {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.implementacoes.Objetos to javafx.base, javafx.fxml;
    opens com.implementacoes to javafx.fxml;
    
    exports com.implementacoes;
}
