package com.example.mughal.ratingaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mughal on 8/8/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public   static  final  String DATABASE_NAME="rating.db";

    public static final String TABLE_NAME = "people_table";
    public static final String COL1 = "ID";
    public static final String COL2= "NAME";
    public static final String COL3 = "rate";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT  , "+ COL3 +  "TEXT)";


        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public  boolean insertData(String name){


SQLiteDatabase db= this.getWritableDatabase();
        ContentValues con= new ContentValues();
        con.put(COL2,name);
long res = db.insert(TABLE_NAME, null,con);
if(res==-1){

    return false;
}else {
    return true;

}
    }

    public Cursor getDATA(){

        SQLiteDatabase db= this.getWritableDatabase();
Cursor resl=db.rawQuery(" select * from " +TABLE_NAME,null);
return resl;

    }
}
