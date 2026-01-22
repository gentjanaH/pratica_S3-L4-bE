package gentjanahani.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento {
    //ATTRIBUTI
    @Column(name = "squadra_casa", nullable = false)
    private String squadraCasa;
    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "gol_casa", nullable = false)
    private int golCasa;
    @Column(name = "gol_ospite", nullable = false)
    private int golOspite;

    public PartitaDiCalcio() {

    }

    public PartitaDiCalcio(
            String titolo,
            LocalDate dataEvento,
            String descrizione,
            EventoType type,
            int numeroMaxPartecipanti,
            String casa,
            String ospite,
            String winner,
            int golCasa,
            int golOspite) {
        super(titolo, dataEvento, descrizione, type, numeroMaxPartecipanti);
        this.squadraCasa = casa;
        this.squadraOspite = ospite;
        this.squadraVincente = winner;
        this.golCasa = golCasa;
        this.golOspite = golOspite;

    }

    //GETTER E SETTER


    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}';
    }
}
