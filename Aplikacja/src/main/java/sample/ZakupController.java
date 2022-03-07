package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ZakupController implements Initializable {

    @FXML
    Label text = new Label();

    @FXML
    Label marka = new Label();

    @FXML
    Label model = new Label();

    @FXML
    Label silnik = new Label();

    @FXML
    Label skrzynia = new Label();

    @FXML
    Label naped = new Label();

    @FXML
    Label kolor = new Label();

    @FXML
    Label nadwozie = new Label();

    @FXML
    Label wnetrze = new Label();

    @FXML
    Label cena = new Label();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(ActiveUser.tryb1==0)
        {

        }
        else if(ActiveUser.tryb1==1)
        {
            text.setText("Czy napewno chcesz usunac:");
        }
        else if(ActiveUser.tryb1==2)
        {
            text.setText("Czy napewno chcesz przeniesc do kupionych:");
        }

        EntityManager entityManager = App.factory.createEntityManager();
        System.out.println(Salon.index);

        Query query = entityManager.createQuery("select k.marka from Katalog k where id_poj=(select s.katalog_poj_id_poj from Salon s where s.id_ofe= :index)");
        query.setParameter("index",Salon.index);

        marka.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.model from Katalog k where id_poj=(select s.katalog_poj_id_poj from Salon s where s.id_ofe= :index)");
        query.setParameter("index",Salon.index);

        model.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.pojemnosc_silnika from Silnik k where id_sil=(select s.wersje_sil_id_sil from Salon s where s.id_ofe= :index)");
        query.setParameter("index",Salon.index);

        Query query1 = entityManager.createQuery("select k.moc_silnika from Silnik k where id_sil=(select s.wersje_sil_id_sil from Salon s where s.id_ofe= :index)");
        query1.setParameter("index",Salon.index);

        silnik.setText(query.getSingleResult() + "l " + query1.getSingleResult() + "KM");

        query = entityManager.createQuery("select k.rodzaj_skrzyni_biegow from Silnik k where id_sil=(select s.wersje_sil_id_sil from Salon s where s.id_ofe= :index)");
        query.setParameter("index",Salon.index);

        skrzynia.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.rodzaj_napedu from Silnik k where id_sil=(select s.wersje_sil_id_sil from Salon s where s.id_ofe= :index)");
        query.setParameter("index",Salon.index);

        naped.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.kolor_karoseri from Wyposazenie k where id_wyp=(select s.wersje_wyp_id_wyp from Salon s where id_ofe= :index)");
        query.setParameter("index",Salon.index);

        kolor.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.typ_nadwozia from Wyposazenie k where id_wyp=(select s.wersje_wyp_id_wyp from Salon s where id_ofe= :index)");
        query.setParameter("index",Salon.index);

        nadwozie.setText((String) query.getSingleResult());

        query = entityManager.createQuery("select k.rodzaj_foteli from Wyposazenie k where id_wyp=(select s.wersje_wyp_id_wyp from Salon s where id_ofe= :index)");
        query.setParameter("index",Salon.index);

        query1 = entityManager.createQuery("select k.kolor_tapicerki from Wyposazenie k where id_wyp=(select s.wersje_wyp_id_wyp from Salon s where id_ofe= :index)");
        query1.setParameter("index",Salon.index);

        wnetrze.setText(query.getSingleResult() + ", kolor: " + query1.getSingleResult());

        query = entityManager.createQuery("select s.cena_w_salonie from Salon s where id_ofe= :index");
        query.setParameter("index",Salon.index);

        cena.setText(query.getSingleResult() + "zl");



    }

    @FXML
    private void back() throws IOException{
        App.setRoot("secondary");
    }

    @FXML
    private void ok() throws IOException {

        if (ActiveUser.tryb1 == 0 || ActiveUser.tryb1 == 2) {
            EntityManager entityManager = App.factory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            LocalDate date = LocalDate.now();

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("zakup")
                    .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(3, Date.class, ParameterMode.IN)

                    .setParameter(1, ActiveUser.id_kli)
                    .setParameter(2, Salon.index)
                    .setParameter(3, java.sql.Date.valueOf(date));

            query.execute();

            query = entityManager.createStoredProcedureQuery("usuniecie_ofe")
                    .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                    .setParameter(1, Salon.index);

            query.execute();

            if(ActiveUser.tryb1==0)
                ActiveUser.tryb = 0;
            else if(ActiveUser.tryb1==2)
                ActiveUser.tryb = 2;

            App.setRoot("potwierdzenie");
        }
        else if(ActiveUser.tryb1==1)
        {
            EntityManager entityManager = App.factory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usun_pojazd")
                    .registerStoredProcedureParameter(1,Long.class,ParameterMode.IN)
                    .setParameter(1,Salon.index);

            query.execute();

            ActiveUser.tryb=3;

            App.setRoot("potwierdzenie");

        }


    }


}
