package gentjanahani.dao;

import gentjanahani.entities.Partecipazione;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePartecipation(Partecipazione newPartecipazione) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo  al PersistenceContext.
        entityManager.persist(newPartecipazione);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("La partecipazione a:  " + newPartecipazione.getEvento() + " è stata salvata correttamente.");
    }

    public Partecipazione getPartecipazioneById(UUID idPartecipazione) {
        Partecipazione found = entityManager.find(Partecipazione.class, idPartecipazione);
        if (found == null) throw new NotFoundException(idPartecipazione.toString());
        return found;
    }

    public void delete(UUID idPartecipazione) {
        // 1. Cerco  tramite id nel DB
        Partecipazione found = this.getPartecipazioneById(idPartecipazione);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo  l'oggetto in questione tramite metodo .remove()
        entityManager.remove(found);

        // 5.  COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("La partecipazione con id: " + idPartecipazione + " è stata eliminata correttamente!");
    }
}
