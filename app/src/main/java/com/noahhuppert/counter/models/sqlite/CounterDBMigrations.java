package com.noahhuppert.counter.models.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.noahhuppert.counter.models.sqlite.migrations.DBMigration;
import com.noahhuppert.counter.models.sqlite.migrations.Migration_None_To_0;

public class CounterDBMigrations {
    private static final DBMigration[] MIGRATIONS = new DBMigration[]{
        new Migration_None_To_0()
    };

    public static void RunMigrationToBumpVersion(int startVersion, SQLiteDatabase db) {
        for(DBMigration migration : MIGRATIONS) {
            if(migration.DB_START_VERSION == startVersion) {
                migration.run(db);
                return;
            }
        }

        throw new RuntimeException("No migration found that starts at " + startVersion);
    }
}
