package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ZamowienieController implements Initializable {

    @FXML
    ComboBox wyp = new ComboBox();

    @FXML
    ComboBox sil = new ComboBox();

    @FXML
    Label label = new Label();


    ObservableList<String> listaWyp = FXCollections.observableArrayList();

    ObservableList<String> listaSil = FXCollections.observableArrayList();





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(ActiveUser.admin==1)
        {
            label.setText("Dodaj pojazd do oferty salonu");
        }




        List<String> listaWyp2 =new ArrayList<>();
        List<String> listaSil2 = new ArrayList<>();

        for(Wyposazenie x : Wyposazenie.list)
        {
            listaWyp2.add( x.toString());
        }

        for(Silnik x : Silnik.list)
        {
            listaSil2.add( x.toString());
        }



        listaWyp.addAll(listaWyp2);
        listaSil.addAll(listaSil2);

        wyp.setItems(listaWyp);

        sil.setItems(listaSil);


//        System.out.println(Salon.index);
//        System.out.println(Katalog.index);



    }

    @FXML
    private void back() throws IOException{
        App.setRoot("secondary");
    }

    @FXML
    private void ok() throws IOException {

        int indexWyp = wyp.getSelectionModel().getSelectedIndex();
        int indexSil = sil.getSelectionModel().getSelectedIndex();


        if (ActiveUser.admin == 1) {

            Zamowienia.newId_poj=Katalog.index;
            Zamowienia.newId_wyp=Wyposazenie.list.get(indexWyp).getId_wyp();
            Zamowienia.newId_sil=Silnik.list.get(indexSil).getId_sil();

            ActiveUser.tryb3=0;
            App.setRoot("cena");

        } else {

            EntityManager entityManager = App.factory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            LocalDate date = LocalDate.now();



            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("zamowienie")
                    .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(3, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(4, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(5, Date.class, ParameterMode.IN)

                    .setParameter(1, ActiveUser.id_kli)
                    .setParameter(2, Katalog.index)
                    .setParameter(3, Wyposazenie.list.get(indexWyp).getId_wyp())
                    .setParameter(4, Silnik.list.get(indexSil).getId_sil())
                    .setParameter(5, java.sql.Date.valueOf(date));

            query.execute();

            ActiveUser.tryb = 1;
            App.setRoot("potwierdzenie");
        }
    }
}
