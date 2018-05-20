package com.example.sqlitedtbsjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student_table";
    public static final String COL_1="Id";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARKS";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if Exists "+TABLE_NAME);
    }

    public boolean insertData(String name,String surname,String marks){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result == -1){
            return false;
        }
        else
            return true;
    }

    public Cursor getAllData(){

        SQLiteDatabase db=getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        db.update(TABLE_NAME,contentValues,"Id = ?",new String[] { id });
        return true;
    }

    public Integer deleteData(String id){

        SQLiteDatabase db=getWritableDatabase();
        return db.delete(TABLE_NAME,"Id = ?",new String[]{ id });
    }
}