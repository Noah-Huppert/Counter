package com.noahhuppert.counter.models.sqlite;

import android.provider.BaseColumns;

public final class CounterDBContract {
    private CounterDBContract() {}

    public static abstract class CounterEntry implements BaseColumns {
        public static final String TABLE_NAME = "counters";

        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CREATION_DATE = "creation_date";
        //public static final String
    }
}
