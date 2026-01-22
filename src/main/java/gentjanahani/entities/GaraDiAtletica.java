package gentjanahani.entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {
    //ATTRIBUTI


    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> setAtleti = new ArrayList<>();

    //COSTRUTTORE
    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo,
                          LocalDate dataEvento,
                          String descrizione,
                          EventoType type,
                          int numeroMaxPartecipanti,
                          List<Persona> setAtleti,
                          Persona vincitore) {
        super(titolo, dataEvento, descrizione, type, numeroMaxPartecipanti);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    //GETTER E SETTER

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(List<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }


}
