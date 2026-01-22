package gentjanahani.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("L'evento con id: " + id + " non è stato trovato!");

    }
}

