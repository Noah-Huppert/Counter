package com.noahhuppert.counter.models.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

public interface DBModel {
    int insert(@NonNull SQLiteDatabase db);
    void loadFromDB(int id, @NonNull SQLiteDatabase db);
    void update(@NonNull SQLiteDatabase db);
    void delete(@NonNull SQLiteDatabase db);

    /**
     * Checks to see if the model is in a state where it could be inserted into the DB
     *
     * This usually involves checking for null values
     * @return true if valid, false if not
     */
    boolean inValidDBState();
}
