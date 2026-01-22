package gentjanahani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "evento")
public class Evento {
    //attributi
    //id
    @Id
    @GeneratedValue
    private UUID id;
    //titolo
    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;
    //dataEvento
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    //descrizione
    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String descrizione;
    //tipoEvento(PUBBLICO, PRIVATO)
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventoType tipoEvento;
    //numeroMassimoPartecipanti
    @Column(name = "numeroMaxPartecipanti", nullable = false)
    private int numeroMaxPartecipanti;

    //chiave esterna con Location
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    //collegamento con persona
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni = new ArrayList<>();


    //COSTRUTTORE VUOTO OBBLIGATORIO PER TUTTE LE ENTITIES!

    public Evento() {
        //verrà usato da JPA per costrire degli oggetti quendo leggeremo le righe dalla tabella
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, EventoType type, int numeroMaxPartecipanti) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = type;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;

    }

    //GETTER & SETTER


    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventoType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventoType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMaxPartecipanti() {
        return numeroMaxPartecipanti;
    }

    public void setNumeroMaxPartecipanti(int numeroMaxPartecipanti) {
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
//TOSTRING


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                ", location=" + location +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}

