package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;
import com.noahhuppert.counter.models.sqlite.exceptions.DBOperationFailedException;
import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

import java.util.Calendar;

public class Count implements DBModel {
    public long id = -1;
    public long counterSegmentId = -1;
    public @Nullable Calendar dateTime;

    // Getters
    public @Nullable CounterSegment getCounterSegment(SQLiteDatabase db) {
        if(counterSegmentId >= 0) {
            CounterSegment counterSegment = new CounterSegment();
            try {
                counterSegment.loadFromDB(counterSegmentId, db);
            } catch (NoSuchRowException e) {
                // TODO: Handle NoSuchRowException
            }

            return counterSegment;
        }

        return null;
    }

    // DB Model
    @Override
    public long insert(@NonNull SQLiteDatabase db) throws IncompleteDBModelException, DBOperationFailedException {
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
