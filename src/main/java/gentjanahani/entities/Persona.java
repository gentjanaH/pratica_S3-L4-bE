package gentjanahani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Persona")

public class Persona {
    //ATTRIBUTI
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "Cognome", nullable = false)
    private String Surname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "data di nascita", nullable = false)
    private LocalDate dataDiNascita;

    @Column(name = "sesso", nullable = false)
    private GenderType genderType;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioni = new ArrayList<>();


    //COSTRUTTORI
    public Persona() {

    }

    public Persona(String name, String surname, String email, LocalDate dataDiNascita, GenderType genderType) {
        this.name = name;
        this.Surname = surname;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.genderType = genderType;
    }

    //GETTER E SETTER


    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", genderType=" + genderType +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
