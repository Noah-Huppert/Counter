package com.noahhuppert.counter.models.sqlite;

import android.provider.BaseColumns;

public final class CounterDBContract {
    private CounterDBContract() {}

    public static abstract class CounterEntry implements BaseColumns {
        public static final String TABLE_NAME = "counters";

        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CREATION_DATE_TIME = "creation_date_time";
    }

    public static abstract class CounterSessionEntry implements BaseColumns {
        public static final String TABLE_NAME = "counter_sessions";

        public static final String COLUMN_NAME_COUNTER_ID = "counter_id";
        public static final String COLUMN_NAME_CREATION_DATE_TIME = "creation_date_time";
    }

    public static abstract class CounterSegmentEntry implements BaseColumns {
        public static final String TABLE_NAME = "counter_segments";

        public static final String COLUMN_NAME_COUNTER_SESSION_ID = "counter_session_id";
        public static final String COLUMN_NAME_CREATION_DATE_TIME = "creation_date_time";
        public static final String COLUMN_NAME_DATA = "data";
    }

    public static abstract class CountEntry implements BaseColumns {
        public static final String TABLE_NAME = "counts";

        public static final String COLUMN_NAME_COUNTER_SEGMENT_ID = "counter_segment_id";
        public static final String COLUMN_NAME_DATA_TIME = "date_time";
    }
}

