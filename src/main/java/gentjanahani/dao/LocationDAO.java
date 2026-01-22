package gentjanahani.dao;

import gentjanahani.entities.Evento;
import gentjanahani.entities.Location;
import gentjanahani.entities.Persona;
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

    public Location getLocationById(String idLocation) {
        Location found = entityManager.find(Location.class, UUID.fromString(idLocation));
        if (found == null) throw new NotFoundException(idLocation);
        return found;
    }

    public void deleteLocation(String idLocation) {
        // 1. Cerco tramite id nel DB
        Location found = this.getLocationById(idLocation);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo  l'oggetto in questione tramite metodo .remove()
        entityManager.remove(found);

        // 5.  COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("La location con id: " + idLocation + " è stata eliminata correttamente!");
    }


}
