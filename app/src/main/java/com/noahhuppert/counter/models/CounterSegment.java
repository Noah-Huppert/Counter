package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;
import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

import java.util.Calendar;

public class CounterSegment implements DBModel {
    public long id = -1;
    public long counterSessionId = -1;
    public @Nullable Calendar creationDateTime;
    public float data = -1;

    // Getters
    public @Nullable CounterSession getCounterSession(SQLiteDatabase db) {
        if(counterSessionId >= 0) {
            CounterSession counterSession = new CounterSession();
            try {
                counterSession.loadFromDB(counterSessionId, db);
            } catch (NoSuchRowException e) {
                // TODO: Handle NoSuchRowException
            }

            return counterSession;
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
