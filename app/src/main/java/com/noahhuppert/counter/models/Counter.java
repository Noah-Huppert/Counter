package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.noahhuppert.counter.models.sqlite.DBModel;

import java.util.Calendar;

public class Counter implements DBModel {
    public int id = -1;
    public @Nullable String name;
    public @Nullable Calendar creationDateTime;

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
                name != null &&
                creationDateTime != null;
    }
}
