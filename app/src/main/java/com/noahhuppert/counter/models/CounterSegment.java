package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;

import java.util.Calendar;

public class CounterSegment implements DBModel {
    public int id = -1;
    public int counterSessionId = -1;
    public @Nullable Calendar creationDateTime;
    public float data = -1;

    // Getters
    public @Nullable CounterSession getCounterSession(SQLiteDatabase db) {
        if(counterSessionId >= 0) {
            CounterSession counterSession = new CounterSession();
            counterSession.loadFromDB(counterSessionId, db);

            return counterSession;
        }

        return null;
    }

    // DB Model
    @Override
    public int insert(@NonNull SQLiteDatabase db) {
        return 0;
    }

    @Override
    public void loadFromDB(int id, @NonNull SQLiteDatabase db) {

    }

    @Override
    public void update(@NonNull SQLiteDatabase db) {

    }

    @Override
    public void delete(@NonNull SQLiteDatabase db) {

    }

    @Override
    public boolean inValidDBState() {
        return  id >= 0 &&
                counterSessionId >= 0 &&
                creationDateTime != null; // data can be -1 because it is Nullable in the DB
    }
}
