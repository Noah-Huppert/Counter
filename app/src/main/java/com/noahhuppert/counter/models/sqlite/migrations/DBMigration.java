package com.noahhuppert.counter.models.sqlite.migrations;

import android.database.sqlite.SQLiteDatabase;

public abstract class DBMigration {
    /**
     * Version of DB that the migration assumes it starts with
     * Used to determine when to run migration
     */
    public final int DB_START_VERSION;

    protected DBMigration(int DB_START_VERSION) {
        this.DB_START_VERSION = DB_START_VERSION;
    }

    public abstract void run(SQLiteDatabase db);
}
