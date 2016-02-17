package com.noahhuppert.counter.models.sqlite.migrations;

import android.database.sqlite.SQLiteDatabase;

import com.noahhuppert.counter.models.sqlite.CounterDBContract;

public class Migration_None_To_0 extends DBMigration {
    public Migration_None_To_0() {
        super(-1);
    }

    @Override
    public void run(SQLiteDatabase db) {
        // Create Counters table
        db.execSQL("CREATE TABLE ? (" +// ? = Counters table name
                        "       ? INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +// ? = id
                        "       ? TEXT                              NOT NULL," +// ? = name
                        "       ? DATETIME                          NOT NULL"  +// ? = creation date time
                        ");",
                new Object[]{
                        CounterDBContract.CounterEntry.TABLE_NAME,
                        CounterDBContract.CounterEntry._ID,
                        CounterDBContract.CounterEntry.COLUMN_NAME_NAME,
                        CounterDBContract.CounterEntry.COLUMN_NAME_CREATION_DATE_TIME
                }
        );

        // Create Counter Sessions table
        db.execSQL("CREATE TABLE ? (" +// ? = Counter Sessions table name
                        "       ? INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +// ?  = id
                        "       ? INTEGER                           NOT NULL," +// ? = counter id
                        "       ? DATETIME                          NOT NULL," +// ? = creation date time
                        "       FOREIGN KEY(?) REFERENCES ?(?)" +// ?(0) = counter id, ?(1) = Counters table name, ?(2) = id
                        ");",
                new Object[]{
                        CounterDBContract.CounterSessionEntry.TABLE_NAME,
                        CounterDBContract.CounterSessionEntry._ID,
                        CounterDBContract.CounterSessionEntry.COLUMN_NAME_COUNTER_ID,
                        CounterDBContract.CounterSessionEntry.COLUMN_NAME_CREATION_DATE_TIME,
                        CounterDBContract.CounterSessionEntry.COLUMN_NAME_COUNTER_ID, CounterDBContract.CounterEntry.TABLE_NAME, CounterDBContract.CounterEntry._ID
                }
        );

        // Create Counter Segments table
        db.execSQL("CREATE TABLE ? (" +// ? = Counter Segments table name
                        "       ? INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +// ? = id
                        "       ? INTEGER                           NOT NULL," +// ? = counter session id
                        "       ? DATETIME                          NOT NULL," +// ? = creation date time
                        "       ? FLOAT," +// ? = data
                        "       FOREIGN KEY(?) REFERENCES ?(?)" +// ?(0) = counter session id, ?(1) = Counter sessions table name, ?(2) = id
                        ");",
                new Object[]{
                        CounterDBContract.CounterSegmentEntry.TABLE_NAME,
                        CounterDBContract.CounterSegmentEntry._ID,
                        CounterDBContract.CounterSegmentEntry.COLUMN_NAME_COUNTER_SESSION_ID,
                        CounterDBContract.CounterSegmentEntry.COLUMN_NAME_CREATION_DATE_TIME,
                        CounterDBContract.CounterSegmentEntry.COLUMN_NAME_DATA,
                        CounterDBContract.CounterSegmentEntry.COLUMN_NAME_COUNTER_SESSION_ID, CounterDBContract.CounterSessionEntry.TABLE_NAME, CounterDBContract.CounterSessionEntry._ID
                }
        );

        // Create Counts table
        db.execSQL("CREATE TABLE ? (" +// ? = Counts table name
                        "       ? INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +// ? = id
                        "       ? INTEGER                           NOT NULL," +// ? = counter segment id
                        "       ? DATETIME                          NOT NULL," +// ? = date time
                        "       FOREIGN KEY(?) REFERENCES ?(?)" + // ?(0) = counter segment id, ?(1) = Counter segments table name, ?(2) = id
                        ");",
                new Object[]{
                        CounterDBContract.CountEntry.TABLE_NAME,
                        CounterDBContract.CountEntry._ID,
                        CounterDBContract.CountEntry.COLUMN_NAME_COUNTER_SEGMENT_ID,
                        CounterDBContract.CountEntry.COLUMN_NAME_DATA_TIME,
                        CounterDBContract.CountEntry.COLUMN_NAME_COUNTER_SEGMENT_ID, CounterDBContract.CounterSegmentEntry.TABLE_NAME, CounterDBContract.CounterSegmentEntry._ID
                }
        );
    }
}
