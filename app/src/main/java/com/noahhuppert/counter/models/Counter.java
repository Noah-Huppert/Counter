package com.noahhuppert.counter.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.CounterDBContract;
import com.noahhuppert.counter.models.sqlite.DBModel;
import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

import java.util.Calendar;

public class Counter implements DBModel {
    public long id = -1;
    public @Nullable String name;
    public @Nullable Calendar creationDateTime;

    // DB Model
    @Override
    public long insert(@NonNull SQLiteDatabase db) throws IncompleteDBModelException {
        // TODO: Create a List<String> of fields that are incomplete and turn into array to thrown exception
        int incompleteFields = 0;

        if(name == null) incompleteFields++;
        if(creationDateTime == null) incompleteFields++;

        ContentValues values = new ContentValues();
        values.put(CounterDBContract.CounterEntry._ID, id);

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
