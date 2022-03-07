package sample;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Katalog_poj")
public class Katalog {
@Id
private long id_poj;
private String marka;
private String model;
private long rok_produkcji;

public static List<Katalog> list;
public static long index;

    public Katalog() {
    }

    public Katalog(long id_poj, String marka, String model, long rok_produkcji) {
        this.id_poj = id_poj;
        this.marka = marka;
        this.model = model;
        this.rok_produkcji = rok_produkcji;
    }

    public long getId_poj() {
        return id_poj;
    }

    public void setId_poj(long id_poj) {
        this.id_poj = id_poj;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(long rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    @Override
    public String toString() {
        return "Katalog{" +
                "id_poj=" + id_poj +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                '}';
    }

}
