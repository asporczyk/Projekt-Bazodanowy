package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "zamowienia")
public class Zamowienia {

    @Id
    private long id_zam;
    private long klienci_id_kli;
    private long katalog_poj_id_poj;
    private long wersje_wyp_id_wyp;
    private long wersje_sil_id_sil;
    private Date data_zamowienia;
    private long zrealizowano;

    public static long newId_kli;
    public static long newId_poj;
    public static long newId_wyp;
    public static long newId_sil;

    public static List<Zamowienia> list;
    public static long index;

    public Zamowienia() {
    }

    public Zamowienia(long id_zam, long klienci_id_kli, long katalog_poj_id_poj, long wersje_wyp_id_wyp, long wersje_sil_id_sil, Date data_zamowienia, long zrealizowano) {
        this.id_zam = id_zam;
        this.klienci_id_kli = klienci_id_kli;
        this.katalog_poj_id_poj = katalog_poj_id_poj;
        this.wersje_wyp_id_wyp = wersje_wyp_id_wyp;
        this.wersje_sil_id_sil = wersje_sil_id_sil;
        this.data_zamowienia = data_zamowienia;
        this.zrealizowano = zrealizowano;
    }

    public long getId_zam() {
        return id_zam;
    }

    public void setId_zam(long id_zam) {
        this.id_zam = id_zam;
    }

    public long getKlienci_id_kli() {
        return klienci_id_kli;
    }

    public void setKlienci_id_kli(long klienci_id_kli) {
        this.klienci_id_kli = klienci_id_kli;
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

    public Date getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(Date data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }


    public long getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(long zrealizowano) {
        this.zrealizowano = zrealizowano;
    }

    @Override
    public String toString() {
        return "Zamowienia{" +
                "id_zam=" + id_zam +
                ", klienci_id_kli=" + klienci_id_kli +
                ", katalog_poj_id_poj=" + katalog_poj_id_poj +
                ", wersje_wyp_id_wyp=" + wersje_wyp_id_wyp +
                ", wersje_sil_id_sil=" + wersje_sil_id_sil +
                ", data_zamowienia=" + data_zamowienia +
                '}';
    }
}
