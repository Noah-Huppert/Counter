package com.noahhuppert.counter.models.sqlite.exceptions;

/**
 * Thrown when a row that does not exist is queried
 */
public class NoSuchRowException extends Exception {
    public long rowId;

    public NoSuchRowException(long rowId) {
        this.rowId = rowId;
    }
}
