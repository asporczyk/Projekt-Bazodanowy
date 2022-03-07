package sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Klienci {
    @Id
    private long id_kli;
    private String imie;
    private String nazwisko;
    private String miasto;
    private String email;
    private long telefon;
    private String haslo;
    private long admin;

    public Klienci() {
    }

    public Klienci(long id_kli, String imie, String nazwisko, String miasto, String email, long telefon, String haslo, long admin ) {
        this.id_kli = id_kli;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.email = email;
        this.telefon = telefon;
        this.haslo = haslo;
        this.admin = admin;
    }

    public long getId_kli() {
        return id_kli;
    }

    public void setId_kli(long id_kli) {
        this.id_kli = id_kli;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public long getAdmin() {
        return admin;
    }

    public void setAdmin(long admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "id_kli=" + id_kli +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", miasto='" + miasto + '\'' +
                ", email='" + email + '\'' +
                ", telefon=" + telefon +
                ", haslo='" + haslo + '\'' +
                ", admin=" + admin + '\'' +
                '}';
    }

}
