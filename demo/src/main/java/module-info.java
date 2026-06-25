module com.implementacoes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.implementacoes.Objetos to javafx.base, javafx.fxml;
    opens com.implementacoes to javafx.fxml;
    opens com.implementacoes.Controllers to javafx.base, javafx.fxml;
    
    
    exports com.implementacoes;
}
