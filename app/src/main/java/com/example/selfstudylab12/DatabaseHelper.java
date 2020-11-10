package com.example.selfstudylab12;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="projectFinalApp.db";
    public static final String TABLE_NAME="User";
    public static final String COL_1="id";
    public static final String COL_2="Name";
    public static final String COL_3="Password";
    public static final String COL_4="type";

    public static final String TABLE_NAME3="Messa";
    public static final String TABLE_NAME2_C1="ids";
    public static final String TABLE_NAME2_C2="Username";
    public static final String TABLE_NAME2_C3="Subject";
    public static final String TABLE_NAME2_C4="Messages";






    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table " + TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT , Password TEXT , type TEXT )" );




        db.execSQL("create table " + TABLE_NAME3 + " ( id INTEGER PRIMARY KEY AUTOINCREMENT , Username TEXT , Subject TEXT , Messages TEXT )" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);

        onCreate(db);

    }

    public boolean insertData(String Name , String Password , String type  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,Password);
        contentValues.put(COL_4,type);

        long result = db.insert(TABLE_NAME,null , contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }



    public Cursor login(String Name,String Password)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from User where Name=? and Password=?",new String[]{Name,Password});


        return cursor;
    }

    public Cursor getListMessages()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor data = db.rawQuery("select * from " + TABLE_NAME3,null);

        return data;

    }


    public boolean saveMessages(String Username,String Subject,String Messages)
    {
        SQLiteDatabase dbS = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_NAME2_C2,Username);
        contentValues.put(TABLE_NAME2_C3,Subject);
        contentValues.put(TABLE_NAME2_C4,Messages);

        long resultS = dbS.insert(TABLE_NAME3,null , contentValues);

        if(resultS == -1)
            return false;
        else
            return true;
    }
}
