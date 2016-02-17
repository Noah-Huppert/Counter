package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;

import java.util.Calendar;

public class CounterSession implements DBModel {
    public int id = -1;
    public int counterId = -1;
    public @Nullable Calendar creationDateTime;

    // Getters
    public @Nullable Counter getCounter(SQLiteDatabase db) {
        if(counterId >= 0) {
            Counter counter = new Counter();
            counter.loadFromDB(counterId, db);

            return counter;
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
                counterId >= 0 &&
                creationDateTime != null;
    }
}
