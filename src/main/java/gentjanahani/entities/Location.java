package gentjanahani.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Location")

public class Location {
    //ATTRIBUTI
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String Nome;

    @Column(name = "Città", nullable = false)
    private String Città;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    //COSTRUTTORI(sempre uno vuoto)
    public Location() {
    }

    public Location(String nome, String city) {
        this.Nome = nome;
        this.Città = city;

    }

    //gettere e setter

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCittà() {
        return Città;
    }

    public void setCittà(String città) {
        Città = città;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Città='" + Città + '\'' +
                /* ", eventi=" + eventi +*/
                '}';
    }
}
