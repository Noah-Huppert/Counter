package com.noahhuppert.counter.models.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

public interface DBModel {
    /**
     * Inserts model into the provided DB
     * @param db Database to insert model
     * @return Id of inserted model
     * @throws IncompleteDBModelException When any field except for the id is not set
     */
    long insert(@NonNull SQLiteDatabase db) throws IncompleteDBModelException;

    /**
     * Sets values of model based on a row in the DB
     * @param id The id of the row to load
     * @param db The database to load from
     * @throws NoSuchRowException When the specified row does not exist
     */
    void loadFromDB(long id, @NonNull SQLiteDatabase db) throws NoSuchRowException;

    /**
     * Updates row in DB based on values in model
     * @param db Database to update
     * @throws IncompleteDBModelException When the id field is not set or when there are no values to update
     */
    void update(@NonNull SQLiteDatabase db) throws IncompleteDBModelException;

    /**
     * Deletes model
     * @param db Database to delete model from
     * @throws IncompleteDBModelException When the id field is not set
     */
    void delete(@NonNull SQLiteDatabase db) throws IncompleteDBModelException;
}
