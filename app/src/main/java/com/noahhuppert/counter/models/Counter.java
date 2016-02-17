package com.noahhuppert.counter.models;

import android.database.sqlite.SQLiteDatabase;

import com.noahhuppert.counter.models.sqlite.DBModel;

public class Counter implements DBModel {
    @Override
    public int insert(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public void loadFromDB(int id, SQLiteDatabase db) {

    }

    @Override
    public void update(SQLiteDatabase db) {

    }

    @Override
    public void delete(SQLiteDatabase db) {

    }
}
