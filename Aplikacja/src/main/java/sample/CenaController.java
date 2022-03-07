package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class CenaController {

    @FXML
    Spinner<Long> spinner = new Spinner<Long>();


    @FXML
    private void wroc() throws IOException {
        if(ActiveUser.tryb3==0)
            App.setRoot("zamowienie");
        else if(ActiveUser.tryb3==1)
            App.setRoot("historia");
    }

    @FXML
    private void ok() throws IOException{

        EntityManager entityManager = App.factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        if(ActiveUser.tryb3==0) {

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("dodaj_pojazd")
                    .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(3, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN)
                    .setParameter(1, Zamowienia.newId_poj)
                    .setParameter(2, Zamowienia.newId_wyp)
                    .setParameter(3, Zamowienia.newId_sil)
                    .setParameter(4, spinner.getValue());


            query.execute();

            App.setRoot("secondary");

        }
        else if(ActiveUser.tryb3==1){

            LocalDate date = LocalDate.now();

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("zrealizuj")
                    .registerStoredProcedureParameter(1,Long.class,ParameterMode.IN)
                    .registerStoredProcedureParameter(2,Long.class,ParameterMode.IN)
                    .registerStoredProcedureParameter(3,Integer.class,ParameterMode.IN)
                    .registerStoredProcedureParameter(4,Date.class,ParameterMode.IN)
                    .setParameter(1,Zamowienia.index)
                    .setParameter(2,Zamowienia.newId_kli)
                    .setParameter(3,spinner.getValue())
                    .setParameter(4,java.sql.Date.valueOf(date));

            query.execute();

            query = entityManager.createStoredProcedureQuery("zam_zr")
                    .registerStoredProcedureParameter(1,Long.class,ParameterMode.IN)
                    .setParameter(1,Zamowienia.index);

            query.execute();

            App.setRoot("historia");


        }

    }
}
