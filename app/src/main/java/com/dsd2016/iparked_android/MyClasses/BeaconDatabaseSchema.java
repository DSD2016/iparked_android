package com.dsd2016.iparked_android.MyClasses;

import android.provider.BaseColumns;

/**
 * Created by Saeedek on 22-Nov-16.
 */

public final class BeaconDatabaseSchema {
    private BeaconDatabaseSchema() {}

    public static class Beacons implements BaseColumns {
        public static final String TABLE_NAME = "beacon";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_MAJOR = "major";
        public static final String COLUMN_BATTERY_CAPACITY = "battery_time_capacity";

    }

}