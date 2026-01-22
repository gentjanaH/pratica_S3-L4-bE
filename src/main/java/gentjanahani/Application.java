package gentjanahani;

import gentjanahani.dao.EventoDAO;
import gentjanahani.dao.LocationDAO;
import gentjanahani.dao.PartecipazioneDAO;
import gentjanahani.dao.PersonaDAO;
import gentjanahani.entities.*;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.dialect.function.StringFunction;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    //per connetterci al DB dobbiamo aggiungere al main questo attributo e passarli il nome della PU
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3l4-gestione-eventipu");

    public static void main(String[] args) {
        // Oggetto speciale che gestisce tutte le interazioni con il DB
        EntityManager entityManager = emf.createEntityManager();
        PersonaDAO persona = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipation = new PartecipazioneDAO(entityManager);
        EventoDAO evento = new EventoDAO(entityManager);
        LocationDAO location = new LocationDAO(entityManager);

        //---------SALVATAGGIO PERSONE, LOCATION, EVENTI------------------
        //PERSONE--
        Persona mario = new Persona("Mario", "Rossi", "mario@rossi.it", LocalDate.of(1995, 7, 12), GenderType.M);
        Persona sara = new Persona("Sara", "Tommasi", "sara@tommasi.com", LocalDate.of(1993, 10, 18), GenderType.F);
//        persona.savePersona(mario);
//        persona.savePersona(sara);
        Persona personaFromDB1 = persona.getPersonaById("4b5f1ac8-52c6-4c8c-80aa-a3e759530901");
        //EVENTI--
        Evento matrimonio = new Evento("Matrimonio Rossi", LocalDate.of(2026, 6, 20), "Centro tavola con rose giralosi, cristalleri Palazzo", EventoType.PRIVATO, 150);
        Evento compleanno = new Evento("Dicciottesimo Martini", LocalDate.of(2026, 3, 8), "Torta a mezzannotte, tovagliato di carta", EventoType.PRIVATO, 50);
        Evento cenaAziendale = new Evento("cena aziendale Epicode", LocalDate.of(2026, 7, 22), "Cena di fine anno, menù a buffet", EventoType.PUBBLICO, 300);
        Evento pasqua = new Evento("pranzo di pasqua", LocalDate.of(2026, 4, 5), "Menù fisso, sono anocra aperte le prenotazioni", EventoType.PUBBLICO, 150);
        Evento natale = new Evento("pranzo di Natale", LocalDate.of(2025, 12, 25), "Menù fisso, sono ancora aperte le prenotazioni", EventoType.PUBBLICO, 150);

        //LOCATION

        Location Villa = new Location("Villa degli Orazi", "Roma");
        Location Ristorante = new Location("La castelluccia", "Roma");
//        location.saveLocation(Villa);
//        location.saveLocation(Ristorante);
        //----RECUPERO LOCATION DAL DB---
        Location RistoranteFromDb = location.getLocationById(
                "3fd15586-4877-4b79-ba70-68ea6aa8fd9f");
        Location VillaFromDb = location.getLocationById(
                "cfad3b48-3e33-42d9-94bc-4b2368ff000b");
//
//        System.out.println(RistoranteFromDb);
//        System.out.println(VillaFromDb);

        //PARTECIPAZIONI


//        matrimonio.setLocation(RistoranteFromDb);
//        compleanno.setLocation(VillaFromDb);
//        cenaAziendale.setLocation(VillaFromDb);
//        pasqua.setLocation(RistoranteFromDb);
//        natale.setLocation(RistoranteFromDb);
//------------------------------------SAVE--------------------------
//        evento.save(matrimonio);
//        evento.save(compleanno);
//        evento.save(cenaAziendale);
//        evento.save(pasqua);
//        evento.save(natale);

        //----------------------GET BY ID-------------------

//        try {
//            Evento eventoCercato = evento.getById("ce0b8f56-e6f7-4aa0-9ae9-d2a1e2d35346");
//            Partecipazione Rossi = new Partecipazione(personaFromDB1, eventoCercato);
//            partecipation.savePartecipation(Rossi);
//            System.out.println("Partecipazione salvata");
//            System.out.println(eventoCercato);
//        } catch (NotFoundException exception) {
//            System.out.println(exception.getMessage());
//        }
        //SET PARTECIPAZIONE
        Partecipazione partRossi = partecipation.getPartecipazioneById("6c0359c9-a430-42c2-9e8b-dfcec829b1d3");
        partRossi.setStato(Stato.CONFERMATA);

        //-------------------------DELETE-------------------
//        try{
//            evento.delete(4);
//
//        }catch(NotFoundException exception){
//            System.out.println(exception.getMessage());
//        }
    }
}

