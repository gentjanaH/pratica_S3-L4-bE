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

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    //per connetterci al DB dobbiamo aggiungere al main questo attributo e passarli il nome della PU
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione-eventi-seconda-partepu");

    public static void main(String[] args) {
        // Oggetto speciale che gestisce tutte le interazioni con il DB
        EntityManager entityManager = emf.createEntityManager();
        //PERSONE
        PersonaDAO persona=new PersonaDAO(entityManager);
        Persona mario=new Persona("Mario", "Rossi", "mario@rossi.it", LocalDate.of(1995,7,12), GenderType.M);
        Persona sara=new Persona("Sara", "Tommasi", "sara@tommasi.com", LocalDate.of(1993, 10,18), GenderType.F);

        //PARTECIPAZIONI
        PartecipazioneDAO partecipation=new PartecipazioneDAO(entityManager);
        Partecipazione Rossi=new Partecipazione()
        //EVENTI
        EventoDAO evento = new EventoDAO(entityManager);

        Evento matrimonio = new Evento("Matrimonio Rossi", LocalDate.of(2026, 6, 20), "Centro tavola con rose giralosi, cristalleri Palazzo", EventoType.PRIVATO, 150);
        Evento compleanno = new Evento("Dicciottesimo Martini", LocalDate.of(2026, 3, 8), "Torta a mezzannotte, tovagliato di carta", EventoType.PRIVATO, 50);
        Evento cenaAziendale = new Evento("cena aziendale Epicode", LocalDate.of(2026, 7, 22), "Cena di fine anno, menù a buffet", EventoType.PUBBLICO, 300);
        Evento pasqua = new Evento("pranzo di pasqua", LocalDate.of(2026, 4, 5), "Menù fisso, sono anocra aperte le prenotazioni", EventoType.PUBBLICO, 150);
        Evento natale = new Evento("pranzo di Natale", LocalDate.of(2025, 12, 25), "Menù fisso, sono ancora aperte le prenotazioni", EventoType.PUBBLICO, 150);

        //crea e salva location
        LocationDAO location = new LocationDAO(entityManager);
        Location Villa = new Location("Villa degli Orazi", "Roma");
        Location Ristorante = new Location("La castelluccia", "Roma");

//RECUPERO LOCATION DAL DB
        Location RistoranteFromDb = location.getById(
                "db5fc2d1-15c4-4ef0-b765-a0597812fc19");
        Location VillaFromDb = location.getById(
                "f48b70ac-7e1b-4325-9cc2-09d404c0affa"
        );
        System.out.println(RistoranteFromDb);
        System.out.println(VillaFromDb);
//        location.saveLocation(Villa);
//        location.saveLocation(Ristorante);
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

//        try{
//            Evento eventoCercato=evento.getById(2);
//            System.out.println(eventoCercato);
//        }catch(NotFoundException exception){
//            System.out.println(exception.getMessage());
//        }


        //-------------------------DELETE-------------------
//        try{
//            evento.delete(4);
//
//        }catch(NotFoundException exception){
//            System.out.println(exception.getMessage());
//        }
    }
}

