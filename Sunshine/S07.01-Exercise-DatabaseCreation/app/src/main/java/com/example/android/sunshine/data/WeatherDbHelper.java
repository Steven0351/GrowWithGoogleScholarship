/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Manages a local database for weather data.
 */

public class WeatherDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "weather.db";
    private static final int DATABASE_VERSION = 1;

    public WeatherDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDbQuery = "CREATE TABLE " + WeatherContract.WeatherEntry.TABLE_NAME + "(" +
                WeatherContract.WeatherEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WeatherContract.WeatherEntry.COLUMN_DATE + " TEXT NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_WEATHER_ID + " TEXT NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_MIN_TEMP + " INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_MAX_TEMP + " INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_HUMIDITY + " INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_PRESSURE + " INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_WIND_SPEED + " INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_DEGREES + " INTEGER NOT NULL" + ");";

        db.execSQL(createDbQuery);
    }

//  TODO (16) Override onUpgrade, but don't do anything within it yet

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}