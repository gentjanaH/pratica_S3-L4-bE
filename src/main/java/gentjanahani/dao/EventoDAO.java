package gentjanahani.dao;

import gentjanahani.entities.Evento;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo il newEvento al PersistenceContext.
        entityManager.persist(newEvento);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L'evento " + newEvento.getTitolo() + " è stato salvato correttamente.");
    }

    public Evento getById(UUID idEvento) {
        Evento found = entityManager.find(Evento.class, idEvento);
        if (found == null) throw new NotFoundException(idEvento.toString());
        return found;
    }

    public void delete(UUID idEvento) {
        // 1. Cerco l'evento tramite id nel DB
        Evento found = this.getById(idEvento);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo  l'oggetto in questione tramite metodo .remove()
        entityManager.remove(found);

        // 5.  COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("L' evento con id: " + idEvento + " è stato eliminato correttamente!");
    }
}

