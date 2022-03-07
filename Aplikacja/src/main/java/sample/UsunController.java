package sample;

import javafx.fxml.FXML;

import java.io.IOException;

public class UsunController {

    @FXML
    private void wroc() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void usun() throws IOException {
        ActiveUser.tryb1=1;
        App.setRoot("zakup");
    }

    @FXML
    private void przenies() throws IOException {
        ActiveUser.tryb1=2;
        App.setRoot("zakup");
    }
}
