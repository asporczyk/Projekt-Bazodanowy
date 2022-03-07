package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Oferta_sal")
public class Salon {

    @Id
    private long id_ofe;
    private long katalog_poj_id_poj;
    private long wersje_wyp_id_wyp;
    private long wersje_sil_id_sil;
    private long cena_w_salonie;
    private String klasa;
    private long kupione;

    public static List<Salon> list;
    public static long index;

    public Salon() {
    }

    public Salon(long id_ofe, long katalog_poj_id_poj, long wersje_wyp_id_wyp, long wersje_sil_id_sil, long cena_w_salonie, String klasa, long kupione) {
        this.id_ofe = id_ofe;
        this.katalog_poj_id_poj = katalog_poj_id_poj;
        this.wersje_wyp_id_wyp = wersje_wyp_id_wyp;
        this.wersje_sil_id_sil = wersje_sil_id_sil;
        this.cena_w_salonie = cena_w_salonie;
        this.klasa = klasa;
        this.kupione = kupione;
    }

    public long getId_ofe() {
        return id_ofe;
    }

    public void setId_ofe(long id_ofe) {
        this.id_ofe = id_ofe;
    }

    public long getKatalog_poj_id_poj() {
        return katalog_poj_id_poj;
    }

    public void setKatalog_poj_id_poj(long katalog_poj_id_poj) {
        this.katalog_poj_id_poj = katalog_poj_id_poj;
    }

    public long getWersje_wyp_id_wyp() {
        return wersje_wyp_id_wyp;
    }

    public void setWersje_wyp_id_wyp(long wersje_wyp_id_wyp) {
        this.wersje_wyp_id_wyp = wersje_wyp_id_wyp;
    }

    public long getWersje_sil_id_sil() {
        return wersje_sil_id_sil;
    }

    public void setWersje_sil_id_sil(long wersje_sil_id_sil) {
        this.wersje_sil_id_sil = wersje_sil_id_sil;
    }

    public long getCena_w_salonie() {
        return cena_w_salonie;
    }

    public void setCena_w_salonie(long cena_w_salonie) {
        this.cena_w_salonie = cena_w_salonie;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public long getKupione() {
        return kupione;
    }

    public void setKupione(long kupione) {
        this.kupione = kupione;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id_ofe=" + id_ofe +
                ", katalog_poj_id_poj=" + katalog_poj_id_poj +
                ", wersje_wyp_id_wyp=" + wersje_wyp_id_wyp +
                ", wersje_sil_id_sil=" + wersje_sil_id_sil +
                ", cena_w_salonie=" + cena_w_salonie +
                ", klasa='" + klasa + '\'' +
                '}';
    }
}
