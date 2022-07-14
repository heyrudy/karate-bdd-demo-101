package com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.exceptions;

public final class DbInteractionException extends RuntimeException {

    public DbInteractionException(String message) {
        super(message);
    }
}
