package gentjanahani.dao;

import gentjanahani.entities.GaraDiAtletica;
import gentjanahani.entities.Partecipazione;
import gentjanahani.entities.PartitaDiCalcio;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class PartitaDiCalcioDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public PartitaDiCalcioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePartita(PartitaDiCalcio newPartita) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo  al PersistenceContext.
        entityManager.persist(newPartita);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("Partita:  " + newPartita.getTitolo() + " è stata salvata correttamente.");
    }


}
