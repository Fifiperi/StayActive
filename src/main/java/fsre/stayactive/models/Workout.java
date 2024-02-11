package fsre.stayactive.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Workout {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=3, max=20, message = "Polje ime mora biti između 3 i 20 znakova.")
    @NotBlank(message="Polje ime je obvezno")
    String ime;

    @Size(min=3, max=50, message = "Polje opis mora biti između 3 i 50 znakova.")
    @NotBlank(message="Polje opis je obvezno")
    String opis;

    @NotBlank(message="Polje brojPonavljanja je obvezno")
    int brojPonavljanja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public String getTezinaVjezbe() {
        return tezinaVjezbe;
    }

    public void setTezinaVjezbe(String tezinaVjezbe) {
        this.tezinaVjezbe = tezinaVjezbe;
    }
public Workout(){}
    public Workout(Long id, String ime, String opis, int brojPonavljanja, String tezinaVjezbe) {
        this.id = id;
        this.ime = ime;
        this.opis = opis;
        this.brojPonavljanja = brojPonavljanja;
        this.tezinaVjezbe = tezinaVjezbe;
    }

    public Workout(Long id, String ime, String opis, int brojPonavljanja) {
        this.id = id;
        this.ime = ime;
        this.opis = opis;
        this.brojPonavljanja = brojPonavljanja;
    }

    @NotBlank(message="Polje tezinaVjezbe je obvezno")
    String tezinaVjezbe;

    @Override
    public String toString() {
        return
                "Ime vjezbe: " + ime + "<br>" +
                "Opis: " + opis + "<br>" +
                "Broj Ponavljanja: " + brojPonavljanja + "<br><br>" +
                "Tezina:" + tezinaVjezbe;
    }
}