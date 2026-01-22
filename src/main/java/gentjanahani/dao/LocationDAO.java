package gentjanahani.dao;

import gentjanahani.entities.Evento;
import gentjanahani.entities.Location;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveLocation(Location newLocation) {
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo il newEvento al PersistenceContext.
        entityManager.persist(newLocation);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("La location "
                + newLocation.getNome()
                + " a "
                + newLocation.getCittà()
                + " è stata salvata correttamente.");
    }

    public Location getById(String idLocation) {
        Location found = entityManager.find(Location.class, UUID.fromString(idLocation));
        if (found == null) throw new NotFoundException(idLocation);
        return found;
    }


}
