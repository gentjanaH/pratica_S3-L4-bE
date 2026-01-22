package gentjanahani.dao;

import gentjanahani.entities.GaraDiAtletica;
import gentjanahani.entities.Partecipazione;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class GaraDiAtleticaDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public GaraDiAtleticaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveGaraDiAtletica(GaraDiAtletica newGara) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo  al PersistenceContext.
        entityManager.persist(newGara);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("Gara con gli atleti:  " + newGara.getSetAtleti() + " è stata salvata correttamente.");
    }

    public GaraDiAtletica getGaraById(String idGara) {
        GaraDiAtletica found = entityManager.find(GaraDiAtletica.class, UUID.fromString(idGara));
        if (found == null) throw new NotFoundException(idGara);
        return found;
    }

    public void deleteGara(String idGara) {
        // 1. Cerco  tramite id nel DB
        GaraDiAtletica found = this.getGaraById(idGara);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo  l'oggetto in questione tramite metodo .remove()
        entityManager.remove(found);

        // 5.  COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("La gara con id: " + idGara + " è stata eliminata correttamente!");
    }

}
