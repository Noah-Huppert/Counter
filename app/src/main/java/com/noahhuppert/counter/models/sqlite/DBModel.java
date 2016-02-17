package com.noahhuppert.counter.models.sqlite;

import android.database.sqlite.SQLiteDatabase;

public interface DBModel {
    int insert(SQLiteDatabase db);
    void loadFromDB(int id, SQLiteDatabase db);
    void update(SQLiteDatabase db);
    void delete(SQLiteDatabase db);
}
