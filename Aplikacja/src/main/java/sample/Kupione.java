package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "kupione_poj")
public class Kupione {


    private long klienci_id_kli;
    @Id
    private long oferta_sal_id_ofe;
    private Date data;


    public static List<Kupione> list;

    public Kupione() {
    }

    public Kupione(long klienci_id_kli, long oferta_sal_id_ofe, Date data) {
        this.klienci_id_kli = klienci_id_kli;
        this.oferta_sal_id_ofe = oferta_sal_id_ofe;
        this.data = data;
    }

    public long getKlienci_id_kli() {
        return klienci_id_kli;
    }

    public void setKlienci_id_kli(long klienci_id_kli) {
        this.klienci_id_kli = klienci_id_kli;
    }

    public long getOferta_sal_id_ofe() {
        return oferta_sal_id_ofe;
    }

    public void setOferta_sal_id_ofe(long oferta_sal_id_ofe) {
        this.oferta_sal_id_ofe = oferta_sal_id_ofe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Kupione{" +
                "klienci_id_kli=" + klienci_id_kli +
                ", oferta_sal_id_ofe=" + oferta_sal_id_ofe +
                ", data=" + data +
                '}';
    }
}
