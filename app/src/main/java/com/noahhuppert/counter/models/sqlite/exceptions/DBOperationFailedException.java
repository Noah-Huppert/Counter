package com.noahhuppert.counter.models.sqlite.exceptions;

/**
 * An exception thrown when an unknown error occurs in a database operation.
 */
public class DBOperationFailedException extends Exception {
    public DBOperationFailedException(Operation operation) {
        super("Failed to complete database operation \"" + operation + "\", unknown error");
    }

    public enum Operation {
        INSERT,
        QUERY,
        UPDATE,
        DELETE;
    }
}
