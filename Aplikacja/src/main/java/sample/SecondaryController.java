package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SecondaryController implements Initializable {

   @FXML
   TableView<Silnik> tabelaSilnik = new TableView<>();

    private final ObservableList<Silnik> listaSilnik = FXCollections.observableArrayList();

   @FXML
   TableView<Wyposazenie> tabelaWyp = new TableView<>();

    private final ObservableList<Wyposazenie> listaWyp = FXCollections.observableArrayList();

   @FXML
   TableView<Salon> tabelaSalon = new TableView<>();

    private final ObservableList<Salon> listaSalon = FXCollections.observableArrayList();



    @FXML
    Label nazwa = new Label();

    @FXML
    Button button1 = new Button();

    @FXML
    Button button2 = new Button();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(ActiveUser.admin==1)
        {
            button1.setText("Dodaj pojazd");
            button2.setText("Usuń pojazd");
        }

        nazwa.setText(Katalog.list.get((int) Katalog.index-1).getMarka() + " " + Katalog.list.get((int) Katalog.index-1).getModel());

        //System.out.println(Katalog.list.get(Katalog.index));

        long index = (long) Katalog.index;

        EntityManager entityManager = App.factory.createEntityManager();

        Query query = entityManager.createQuery("select k from Silnik k where k.katalog_poj_id_poj = :index");
        query.setParameter("index",index);
        Silnik.list = query.getResultList();

        listaSilnik.addAll(Silnik.list);

        tabelaSilnik.setItems(listaSilnik);

        Query query1 = entityManager.createQuery("select k from Wyposazenie k where k.katalog_poj_id_poj = :index");
        query1.setParameter("index", index);
        Wyposazenie.list = query1.getResultList();

        listaWyp.addAll(Wyposazenie.list);
        tabelaWyp.setItems(listaWyp);

        Query query2 = entityManager.createQuery("select k from Salon k where k.katalog_poj_id_poj = :index and k.kupione= 0");
        query2.setParameter("index", index);
        Salon.list = query2.getResultList();

        listaSalon.addAll(Salon.list);
        tabelaSalon.setItems(listaSalon);



    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void wybierz() throws IOException {

        TableView.TableViewSelectionModel<Salon> selectionModel = tabelaSalon.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

//        int index = selectionModel.getFocusedIndex();
//
//        Salon.index = listaSalon.get(index).getId_ofe();

        Salon.index = selectionModel.getSelectedItem().getId_ofe();



        //System.out.println(Salon.index);

        if(ActiveUser.admin==1)
        {
            App.setRoot("usun");
        }
        else {
            ActiveUser.tryb1=0;
            App.setRoot("zakup");
        }

    }

    @FXML
    private void zamow() throws IOException{
        App.setRoot("zamowienie");
    }
}