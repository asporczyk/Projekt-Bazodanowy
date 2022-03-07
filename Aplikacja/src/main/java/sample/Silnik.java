package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Wersje_sil")
public class Silnik {

    @Id
    private long id_sil;
    private BigDecimal pojemnosc_silnika;
    private long moc_silnika;
    private String rodzaj_skrzyni_biegow;
    private long liczba_cylindrow;
    private String typ_silnika;
    private String rodzaj_napedu;
    private long katalog_poj_id_poj;

    public static List<Silnik> list;

    public Silnik() {
    }

    public Silnik(long id_sil, BigDecimal pojemnosc_silnika, long moc_silnika, String rodzaj_skrzyni_biegow, long liczba_cylindrow, String typ_silnika, String rodzaj_napedu, long katalog_poj_id_poj) {
        this.id_sil = id_sil;
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.moc_silnika = moc_silnika;
        this.rodzaj_skrzyni_biegow = rodzaj_skrzyni_biegow;
        this.liczba_cylindrow = liczba_cylindrow;
        this.typ_silnika = typ_silnika;
        this.rodzaj_napedu = rodzaj_napedu;
        this.katalog_poj_id_poj = katalog_poj_id_poj;
    }

    public long getId_sil() {
        return id_sil;
    }

    public void setId_sil(long id_sil) {
        this.id_sil = id_sil;
    }

    public BigDecimal getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(BigDecimal pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public long getMoc_silnika() {
        return moc_silnika;
    }

    public void setMoc_silnika(long moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public String getRodzaj_skrzyni_biegow() {
        return rodzaj_skrzyni_biegow;
    }

    public void setRodzaj_skrzyni_biegow(String rodzaj_skrzyni_biegow) {
        this.rodzaj_skrzyni_biegow = rodzaj_skrzyni_biegow;
    }

    public long getLiczba_cylindrow() {
        return liczba_cylindrow;
    }

    public void setLiczba_cylindrow(long liczba_cylindrow) {
        this.liczba_cylindrow = liczba_cylindrow;
    }

    public String getTyp_silnika() {
        return typ_silnika;
    }

    public void setTyp_silnika(String typ_silnika) {
        this.typ_silnika = typ_silnika;
    }

    public String getRodzaj_napedu() {
        return rodzaj_napedu;
    }

    public void setRodzaj_napedu(String rodzaj_napedu) {
        this.rodzaj_napedu = rodzaj_napedu;
    }

    public long getKatalog_poj_id_poj() {
        return katalog_poj_id_poj;
    }

    public void setKatalog_poj_id_poj(long katalog_poj_id_poj) {
        this.katalog_poj_id_poj = katalog_poj_id_poj;
    }

    @Override
    public String toString() {
        return
                pojemnosc_silnika + "l, " +
                moc_silnika + "KM, " +
                "skrzynia biegow: " + rodzaj_skrzyni_biegow +
                ", rodzaj napedu: " + rodzaj_napedu;
    }
}
