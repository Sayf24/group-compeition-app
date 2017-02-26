package com.example.sayf.groupcompetition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.provider.SyncStateContract;

import static com.example.sayf.groupcompetition.R.drawable.db;

/**
 * Created by Sayf on 2/23/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper implements BaseColumns {
    //Declares the table name, the database name, and the column name, MUST CHANGE VERSION EVERYTIME
    private static final int DATABASE_VERSION = 12;
    private static final String DATABASE_NAME = "scores.db";
    public static final String TABLE_GROUPS = "GROUPS";
    public static final String COLUMN_SCORE = "Scores";
    // databse constructor
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //creates the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_GROUPS + "(" + "_ID" +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SCORE + " TEXT );";
        db.execSQL(query);
    }
    //no clue what it does but it gives me an error if i dont implement it
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUPS);
        onCreate(db);
    }
    //adds group to database
    public void addGroup(GroupClass group) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, group.toString());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_GROUPS, null, values);
        db.close();
    }
    //makes the database viewable and understandable
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_GROUPS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("Scores")) != null) {
                dbString += c.getString(c.getColumnIndex("Scores"));
                dbString += "\n";
                c.moveToNext();
            }

        }
        db.close();
        return dbString;
    }
    //TODO:fix this
    public void updateInfo(GroupClass group){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SCORE, group.toString());
        db.update(TABLE_GROUPS, cv, COLUMN_SCORE + "= ?", new String[] {"Scores"});
    }

}