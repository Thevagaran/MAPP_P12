package com.android.example.wordlistsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordListOpenHelper extends SQLiteOpenHelper {

    // It's a good idea to always define a log tag like this.
    private static final String TAG = WordListOpenHelper.class.getSimpleName();
    // has to be 1 first time or app will crash
    private static final int DATABASE_VERSION = 1;
    private static final String WORD_LIST_TABLE = "word_entries";
    private static final String DATABASE_NAME = "wordlist";
    // Column names...
    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_DATE = "date";

    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

    // Create a container for the data.
    ContentValues values = new ContentValues();


    // ... and a string array of columns.
    private static final String[] COLUMNS = { KEY_ID, KEY_WORD, KEY_DATE };

    // Build the SQL query that creates the table.
    private static final String WORD_LIST_TABLE_CREATE = "CREATE TABLE " + WORD_LIST_TABLE + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_WORD + " TEXT, " + KEY_DATE + "TEXT );";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WORD_LIST_TABLE_CREATE);
        fillDatabaseWithData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public WordListOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private void fillDatabaseWithData(SQLiteDatabase db){
        String[] words = {"Android", "Adapter", "ListView", "AsyncTask",
                "Android Studio", "SQLiteDatabase", "SQLOpenHelper",
                "Data model", "ViewHolder","Android Performance",
                "OnClickListener"};
    }
}
