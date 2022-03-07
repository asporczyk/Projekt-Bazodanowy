package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PotwierdzenieController implements Initializable {

    @FXML
    Label text = new Label();

    @FXML
    Label text2 = new Label();

    @FXML
    private void ok() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(ActiveUser.tryb==0)
        {

        }
        else if(ActiveUser.tryb==1) {
            text.setText("Zamówienie zostało złożone");
            text2.setText("Pojazd będzie czekał na odbiór w salonie");
        }
        else if(ActiveUser.tryb==2) {
            text.setText("");
            text2.setText("Pojazd przeniesiony do kupionych");
        }
        else if(ActiveUser.tryb==3){
            text.setText("");
            text2.setText("Pojazd został usunięty");
        }


    }
}
