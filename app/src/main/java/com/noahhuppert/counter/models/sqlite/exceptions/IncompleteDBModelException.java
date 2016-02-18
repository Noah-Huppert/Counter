package com.noahhuppert.counter.models.sqlite.exceptions;

/**
 * Thrown when a required field is not complete in a {@link com.noahhuppert.counter.models.sqlite.DBModel}
 */
public class IncompleteDBModelException extends Exception {
    /**
     * An array of fields that are incomplete in the model.
     *
     * The names of the fields should be those of the columns in the DB, not the fields in the
     * Java model
     */
    public String[] incompleteFields;

    public IncompleteDBModelException(String... incompleteFields) {
        this.incompleteFields = incompleteFields;

        if(this.incompleteFields == null || this.incompleteFields.length == 0) {
            throw new RuntimeException("Expected a list of incomplete fields");
        }
    }
}
