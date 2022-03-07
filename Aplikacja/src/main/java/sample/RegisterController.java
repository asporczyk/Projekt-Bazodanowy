package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.IOException;

public class RegisterController {

    @FXML
    TextField imie = new TextField();

    @FXML
    TextField nazwisko = new TextField();

    @FXML
    TextField miejscowosc = new TextField();

    @FXML
    TextField telefon = new TextField();

    @FXML
    TextField email = new TextField();

    @FXML
    PasswordField password = new PasswordField();

    @FXML
    PasswordField password2 = new PasswordField();

    @FXML
    Label error = new Label();

    @FXML
    private void wroc() throws IOException {

        App.setRoot("login");
    }

    @FXML
    private void zarejestruj() throws IOException {

        if(imie.getText().isEmpty() || nazwisko.getText().isEmpty() || miejscowosc.getText().isEmpty() || email.getText().isEmpty()
                || telefon.getText().isEmpty() || password.getText().isEmpty() || password2.getText().isEmpty() ) {

            error.setText("Żadne pole nie może być puste");
            error.setVisible(true);
        }
        else {
            try {
                if (password.getText().equals(password2.getText())) {

                    EntityManager entityManager = App.factory.createEntityManager();

                    EntityTransaction transaction = entityManager.getTransaction();
                    transaction.begin();

                    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("klienci_security.add_user")
                            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter(6, String.class, ParameterMode.IN)

                            .setParameter(1, email.getText())
                            .setParameter(2, password.getText())
                            .setParameter(3, imie.getText())
                            .setParameter(4, nazwisko.getText())
                            .setParameter(5, miejscowosc.getText())
                            .setParameter(6, telefon.getText());

                    query.execute();

                    App.setRoot("login");

                } else {
                    error.setVisible(true);
                    error.setText("Hasła nie są takie same");
                }
            } catch (RuntimeException e) {
                error.setVisible(true);
                error.setText("Podany email już istnieje");
            }
        }


    }
}
