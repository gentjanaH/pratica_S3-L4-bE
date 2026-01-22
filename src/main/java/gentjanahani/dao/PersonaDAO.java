package gentjanahani.dao;


import gentjanahani.entities.Persona;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePersona(Persona newPersona) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo il newPersona al PersistenceContext.
        entityManager.persist(newPersona);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println(newPersona.getName() + newPersona.getSurname() + " è stato salvato correttamente aggiunto.");
    }

    public Persona getPersonaById(String idPersona) {
        Persona found = entityManager.find(Persona.class, UUID.fromString(idPersona));
        if (found == null) throw new NotFoundException(idPersona);
        return found;
    }

    public void deletePersona(String idPersona) {
        // 1. Cerco tramite id nel DB
        Persona found = this.getPersonaById(idPersona);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo  l'oggetto in questione tramite metodo .remove()
        entityManager.remove(found);

        // 5.  COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("L'utente con id: " + idPersona + " è stato eliminato correttamente!");
    }
}
