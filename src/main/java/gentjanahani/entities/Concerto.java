package gentjanahani.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {
    //ATTRIBUTI
    @Column(name = "genere", nullable = false)
    private ConcertType genereConcerto;
    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    //COSTRUTTORI
    public Concerto() {
    }

    public Concerto(
            String titolo,
            LocalDate dataEvento,
            String descrizione,
            EventoType type,
            int numeroMaxPartecipanti,
            ConcertType genereConcerto,
            boolean inStreaming
    ) {
        super(titolo, dataEvento, descrizione, type, numeroMaxPartecipanti);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    //GETTER E SETTER

    public ConcertType getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(ConcertType genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
