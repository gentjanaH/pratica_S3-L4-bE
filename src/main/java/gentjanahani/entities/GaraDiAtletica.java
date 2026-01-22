package gentjanahani.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {
    //ATTRIBUTI
    @Column(name = "set_atleti", nullable = false)
    List<Persona> setAtleti;
    @Column(name = "vincitore", nullable = false)
    Persona vincitore;

}
