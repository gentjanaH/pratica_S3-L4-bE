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
    private EventoType genereConcerto;
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
            EventoType genereConcerto,
            boolean inStreaming
    ) {
        super(titolo, dataEvento, descrizione, type, numeroMaxPartecipanti);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    //GETTER E SETTER

    public EventoType getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(EventoType genereConcerto) {
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
