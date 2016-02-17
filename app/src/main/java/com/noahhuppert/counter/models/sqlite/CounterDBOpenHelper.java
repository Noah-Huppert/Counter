package com.noahhuppert.counter.models.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CounterDBOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 0;
    public static final String DATABASE_NAME = "Counter.db";

    public CounterDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CounterDBMigrations.Migration_None_To_0(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
