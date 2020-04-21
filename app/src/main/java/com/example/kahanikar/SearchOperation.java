package com.example.kahanikar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class SearchOperation {
    private static final String TAG = "SEARCH_QUERY_DATABASE";
    private static final String DATABASE_NAME="SearchMyItem";
    private static final int DATABASE_VERSION = 1;
    private static final String FTS_VIRTUAL_TABLE="FTS";
    private final static String COL_WORD = "WORD";
    private final static String COL_DEFINITION = "DEFINITION";

    public SearchOperation(Context context){
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
    }
    private static class DatabaseOpenHelper extends SQLiteOpenHelper {
        private static final String FTS_TABLE_CREATE = "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE +
                " USING fts3 (" +
                COL_WORD + ", " +
                COL_DEFINITION + ")";


        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(FTS_TABLE_CREATE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "UPGRADING DATABASE FROM VERSION" + oldVersion + "to" + newVersion + " , which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);

            }
        }
    }
