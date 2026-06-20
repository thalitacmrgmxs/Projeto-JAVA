package com.implementacoes.Controllers;

import java.io.IOException;
import com.implementacoes.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
