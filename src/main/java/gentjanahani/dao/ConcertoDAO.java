package gentjanahani.dao;

import gentjanahani.entities.Concerto;
import gentjanahani.entities.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConcertoDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public ConcertoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveConcerto(Concerto newConcerto) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo  al PersistenceContext.
        entityManager.persist(newConcerto);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("Concerto:  " + newConcerto.getTitolo() + " è stato salvato correttamente.");
    }
}
