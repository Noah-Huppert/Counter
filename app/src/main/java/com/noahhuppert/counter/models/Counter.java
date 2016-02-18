package com.noahhuppert.counter.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.CounterDBContract;
import com.noahhuppert.counter.models.sqlite.DBModel;
import com.noahhuppert.counter.models.sqlite.exceptions.DBOperationFailedException;
import com.noahhuppert.counter.models.sqlite.exceptions.IncompleteDBModelException;
import com.noahhuppert.counter.models.sqlite.exceptions.NoSuchRowException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Counter implements DBModel {
    public long id = -1;
    public @Nullable String name;
    public @Nullable Calendar creationDateTime;

    // DB Model
    @Override
    public long insert(@NonNull SQLiteDatabase db) throws IncompleteDBModelException, DBOperationFailedException {
        ArrayList<String> incompleteFields = new ArrayList<>();

        if(name == null) incompleteFields.add(CounterDBContract.CounterEntry.COLUMN_NAME_NAME);
        if(creationDateTime == null) incompleteFields.add(CounterDBContract.CounterEntry.COLUMN_NAME_CREATION_DATE_TIME);

        if(incompleteFields.size() >= 0) {
            throw new IncompleteDBModelException((String[]) incompleteFields.toArray());
        } else {
            ContentValues values = new ContentValues();
            values.put(CounterDBContract.CounterEntry.COLUMN_NAME_NAME, name);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            values.put(CounterDBContract.CounterEntry.COLUMN_NAME_CREATION_DATE_TIME, dateFormat.format(creationDateTime.getTime()));

            long id = db.insert(CounterDBContract.CounterEntry.TABLE_NAME, null, values);

            if(id != -1) {
                this.id = id;
                return id;
            } else {
                throw new DBOperationFailedException(DBOperationFailedException.Operation.INSERT);
            }
        }
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
