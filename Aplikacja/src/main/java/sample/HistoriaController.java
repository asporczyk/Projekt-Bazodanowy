package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HistoriaController implements Initializable {

    @FXML
    TableView<Zamowienia> tabelaZamowienia = new TableView<>();

    @FXML
    TableView<Kupione> tabelaKupione = new TableView<>();

    @FXML
    TableView<ZamowieniaZR> tabelaZamowieniaZr = new TableView<>();

    @FXML
    Label text = new Label();

    @FXML
    Button button = new Button();

    @FXML
    TableColumn<Date,Kupione> dataZakupu = new TableColumn();


    private final ObservableList<Kupione> listaKupione = FXCollections.observableArrayList();
    private final ObservableList<Zamowienia> listaZamowienia = FXCollections.observableArrayList();
    private final ObservableList<ZamowieniaZR> listaZamowieniaZr = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EntityManager entityManager = App.factory.createEntityManager();

        if(ActiveUser.admin==1) {
            Query query = entityManager.createQuery("select k from Kupione k");
            Kupione.list = query.getResultList();
            listaKupione.addAll(Kupione.list);
            tabelaKupione.setItems(listaKupione);


            query = entityManager.createQuery("select k from Zamowienia k where k.zrealizowano=0");
            Zamowienia.list = query.getResultList();
            listaZamowienia.addAll(Zamowienia.list);
            tabelaZamowienia.setItems(listaZamowienia);

            query = entityManager.createQuery("select k from ZamowieniaZR k ");
            ZamowieniaZR.list = query.getResultList();
            listaZamowieniaZr.addAll(ZamowieniaZR.list);
            tabelaZamowieniaZr.setItems(listaZamowieniaZr);

        }
        else if(ActiveUser.admin==0){

            Query query = entityManager.createQuery("select k from Kupione k where k.klienci_id_kli= :index");
            query.setParameter("index",ActiveUser.id_kli);
            Kupione.list = query.getResultList();
            listaKupione.addAll(Kupione.list);
            tabelaKupione.setItems(listaKupione);

            query = entityManager.createQuery("select k from Zamowienia k where k.klienci_id_kli= :index and k.zrealizowano=0");
            query.setParameter("index",ActiveUser.id_kli);
            Zamowienia.list = query.getResultList();
            listaZamowienia.addAll(Zamowienia.list);
            tabelaZamowienia.setItems(listaZamowienia);

            query = entityManager.createQuery("select k from ZamowieniaZR k where k.zamowienia_klienci_id_kli= :index");
            query.setParameter("index",ActiveUser.id_kli);
            ZamowieniaZR.list = query.getResultList();
            listaZamowieniaZr.addAll(ZamowieniaZR.list);
            tabelaZamowieniaZr.setItems(listaZamowieniaZr);

        }


        tabelaZamowienia.setVisible(false);
        tabelaKupione.setVisible(false);
        tabelaZamowieniaZr.setVisible(false);
        button.setVisible(false);


        if(ActiveUser.tryb2==0) {
            tabelaKupione.setVisible(true);
            text.setText("Kupione pojazdy");
        }
        else if(ActiveUser.tryb2==1) {
            tabelaZamowienia.setVisible(true);
            text.setText("Oczekujące zamówienia");

            if(ActiveUser.admin==1){
                button.setVisible(true);
            }

        }
        else if(ActiveUser.tryb2==2) {
            tabelaZamowieniaZr.setVisible(true);
            text.setText("Zrealizowane zamówienia");
        }


    }

    @FXML
    private void back() throws IOException
    {
        App.setRoot("primary");
    }

    @FXML
    private void left() throws IOException {
        ActiveUser.tryb2--;

        if(ActiveUser.tryb2<0)
            ActiveUser.tryb2=2;

        App.setRoot("historia");
    }

    @FXML
    private void right() throws IOException {
        ActiveUser.tryb2++;

        if(ActiveUser.tryb2>2)
            ActiveUser.tryb2=0;

        App.setRoot("historia");

    }

    @FXML
    private void zrealizuj() throws IOException{

        TableView.TableViewSelectionModel<Zamowienia> selectionModel = tabelaZamowienia.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        Zamowienia.index=selectionModel.getSelectedItem().getId_zam();

        EntityManager entityManager = App.factory.createEntityManager();

        Query query = entityManager.createQuery("select k.klienci_id_kli from Zamowienia k where k.id_zam= :index");
        query.setParameter("index",Zamowienia.index);

        Zamowienia.newId_kli= (long) query.getSingleResult();

        ActiveUser.tryb3=1;
        App.setRoot("cena");




    }

}
