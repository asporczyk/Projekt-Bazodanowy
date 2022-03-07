package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.persistence.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class LoginController {

    @FXML
    TextField login = new TextField();

    @FXML
    PasswordField password = new PasswordField();

    @FXML
    Label label = new Label();


    @FXML
    private boolean zaloguj() throws IOException {

        EntityManager entityManager = App.factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("klienci_security.valid_user")
        .registerStoredProcedureParameter(1,String.class, ParameterMode.IN)
        .registerStoredProcedureParameter(2,String.class, ParameterMode.IN)



        .setParameter(1,login.getText())
        .setParameter(2,password.getText());

                int test=0;


        try{
            query.execute();
            System.out.println(query.getSingleResult());}
            catch(NoResultException e) {
                test=1;
                }
            catch (RuntimeException e){

                test = 0;

            }
            finally {
                transaction.commit();
            }

        if(test==1)
            return true;
        else
            return false;

    }

    @FXML
    private void waliduj() throws IOException {

        if (zaloguj()) {
            //System.out.println("OK");

            ActiveUser.email = login.getText().toUpperCase(Locale.ROOT);

            EntityManager entityManager = App.factory.createEntityManager();

            Query query = entityManager.createQuery("select k.id_kli from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.id_kli= (long) query.getSingleResult();
            //System.out.println(ActiveUser.id_kli);

            query = entityManager.createQuery("select k.imie from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.imie = (String) query.getSingleResult();

            query = entityManager.createQuery("select k.nazwisko from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.nazwisko = (String) query.getSingleResult();

            query = entityManager.createQuery("select k.miasto from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.miasto = (String) query.getSingleResult();

            query = entityManager.createQuery("select k.telefon from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.telefon = (long) query.getSingleResult();

            query = entityManager.createQuery("select k.admin from Klienci k where k.email = :login");
            query.setParameter("login",ActiveUser.email);
            ActiveUser.admin = (long) query.getSingleResult();

            App.setRoot("primary");
        }
        else {
            //System.out.println("Nie ok");

            label.setVisible(true);
        }
    }

    @FXML
    private void zarejestruj() throws IOException {

        App.setRoot("register");
    }




}
