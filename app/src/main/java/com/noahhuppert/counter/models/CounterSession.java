package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;
import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

import java.util.Calendar;

public class CounterSession implements DBModel {
    public long id = -1;
    public long counterId = -1;
    public @Nullable Calendar creationDateTime;

    // Getters
    public @Nullable Counter getCounter(SQLiteDatabase db) {
        if(counterId >= 0) {
            Counter counter = new Counter();
            try {
                counter.loadFromDB(counterId, db);
            } catch (NoSuchRowException e) {
                // TODO: Handle NoSuchRowException
            }

            return counter;
        }

        return null;
    }

    // DB Model
    @Override
    public long insert(@NonNull SQLiteDatabase db) throws IncompleteDBModelException {
        return 0;
    }

    @Override
    public void loadFromDB(long id, @NonNull SQLiteDatabase db) throws NoSuchRowException {

    }

    @Override
    public void update(@NonNull SQLiteDatabase db) throws IncompleteDBModelException {

    }

    @Override
    public void delete(@NonNull SQLiteDatabase db) throws IncompleteDBModelException {

    }

}
