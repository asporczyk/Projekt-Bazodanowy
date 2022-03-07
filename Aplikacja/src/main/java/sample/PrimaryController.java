package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrimaryController implements Initializable {

    @FXML
    private TableView<Katalog> tableView = new TableView<>();

    @FXML
    private Label login = new Label();

    private final ObservableList<Katalog> lista = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        login.setText(ActiveUser.email);

        EntityManager entityManager = App.factory.createEntityManager();

        Query query = entityManager.createQuery("select k from Katalog k");
        Katalog.list = query.getResultList();

//        for(Katalog k : Katalog.list)
//        {
//            System.out.println(k);
//        }
        lista.addAll(Katalog.list);

        tableView.setItems(lista);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void wyloguj() throws IOException{
        App.setRoot("login");
    }

    @FXML
    private void wybierz() throws IOException{

        TableView.TableViewSelectionModel<Katalog> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        Katalog.index = selectionModel.getSelectedItem().getId_poj();

        //System.out.println(Katalog.index);

        App.setRoot("secondary");

    }

    @FXML
    private void zamowienia() throws IOException{
        App.setRoot("historia");

    }
}
