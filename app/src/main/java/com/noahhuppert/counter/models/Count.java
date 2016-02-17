package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;

import java.util.Calendar;

public class Count implements DBModel {
    public int id = -1;
    public int counterSegmentId = -1;
    public @Nullable Calendar dateTime;

    // Getters
    public @Nullable CounterSegment getCounterSegment(SQLiteDatabase db) {
        if(counterSegmentId >= 0) {
            CounterSegment counterSegment = new CounterSegment();
            counterSegment.loadFromDB(counterSegmentId, db);

            return counterSegment;
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
                counterSegmentId >= 0 &&
                dateTime != null;
    }
}
