package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Wersje_wyp")
public class Wyposazenie {

    @Id
    private long id_wyp;
    private String kolor_karoseri;
    private String typ_nadwozia;
    private String rodzaj_foteli;
    private String kolor_tapicerki;
    private long katalog_poj_id_poj;

    public static List<Wyposazenie> list;

    public Wyposazenie() {
    }

    public Wyposazenie(long id_wyp, String kolor_karoseri, String typ_nadwozia, String rodzaj_foteli, String kolor_tapicerki, long katalog_poj_id_poj) {
        this.id_wyp = id_wyp;
        this.kolor_karoseri = kolor_karoseri;
        this.typ_nadwozia = typ_nadwozia;
        this.rodzaj_foteli = rodzaj_foteli;
        this.kolor_tapicerki = kolor_tapicerki;
        this.katalog_poj_id_poj = katalog_poj_id_poj;
    }

    public long getId_wyp() {
        return id_wyp;
    }

    public void setId_wyp(long id_wyp) {
        this.id_wyp = id_wyp;
    }

    public String getKolor_karoseri() {
        return kolor_karoseri;
    }

    public void setKolor_karoseri(String kolor_karoseri) {
        this.kolor_karoseri = kolor_karoseri;
    }

    public String getTyp_nadwozia() {
        return typ_nadwozia;
    }

    public void setTyp_nadwozia(String typ_nadwozia) {
        this.typ_nadwozia = typ_nadwozia;
    }

    public String getRodzaj_foteli() {
        return rodzaj_foteli;
    }

    public void setRodzaj_foteli(String rodzaj_foteli) {
        this.rodzaj_foteli = rodzaj_foteli;
    }

    public String getKolor_tapicerki() {
        return kolor_tapicerki;
    }

    public void setKolor_tapicerki(String kolor_tapicerki) {
        this.kolor_tapicerki = kolor_tapicerki;
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
                kolor_karoseri + ", " +
                typ_nadwozia + ", " +
                "rodzaj foteli: " + rodzaj_foteli +
                ", kolor tapicerki: " + kolor_tapicerki
                ;
    }
}
