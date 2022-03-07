package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "zamowienia_zr")
public class ZamowieniaZR {

    @Id
    private long id_zam_zr;
    private long zamowienia_id_zam;
    private long zamowienia_klienci_id_kli;
    private long cena_zamowienia;
    private Date data_zrealizowania;

    public static List<ZamowieniaZR> list;

    public ZamowieniaZR() {
    }

    public ZamowieniaZR(long id_zam_zr, long zamowienia_id_zam, long zamowienia_klienci_id_kli, long cena_zamowienia, Date data_zrealizowania) {
        this.id_zam_zr = id_zam_zr;
        this.zamowienia_id_zam = zamowienia_id_zam;
        this.zamowienia_klienci_id_kli = zamowienia_klienci_id_kli;
        this.cena_zamowienia = cena_zamowienia;
        this.data_zrealizowania = data_zrealizowania;
    }

    public long getId_zam_zr() {
        return id_zam_zr;
    }

    public void setId_zam_zr(long id_zam_zr) {
        this.id_zam_zr = id_zam_zr;
    }

    public long getZamowienia_id_zam() {
        return zamowienia_id_zam;
    }

    public void setZamowienia_id_zam(long zamowienia_id_zam) {
        this.zamowienia_id_zam = zamowienia_id_zam;
    }

    public long getZamowienia_klienci_id_kli() {
        return zamowienia_klienci_id_kli;
    }

    public void setZamowienia_klienci_id_kli(long zamowienia_klienci_id_kli) {
        this.zamowienia_klienci_id_kli = zamowienia_klienci_id_kli;
    }

    public long getCena_zamowienia() {
        return cena_zamowienia;
    }

    public void setCena_zamowienia(long cena_zamowienia) {
        this.cena_zamowienia = cena_zamowienia;
    }

    public Date getData_zrealizowania() {
        return data_zrealizowania;
    }

    public void setData_zrealizowania(Date data_zrealizowania) {
        this.data_zrealizowania = data_zrealizowania;
    }

    @Override
    public String toString() {
        return "ZamowieniaZR{" +
                "id_zam_zr=" + id_zam_zr +
                ", zamowienia_id_zam=" + zamowienia_id_zam +
                ", zamowienia_klienci_id_kli=" + zamowienia_klienci_id_kli +
                ", cena_zamowienia=" + cena_zamowienia +
                ", data_zrealizowania=" + data_zrealizowania +
                '}';
    }
}
