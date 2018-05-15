package com.example.sqlitjava;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG=MainActivity.class.getCanonicalName();
    DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new DbHelper(this,Db.DB_NAME,null,Db.DB_VERSION);

    }

    public void insert(View view) {

//        rawInsert();
        simmpleInsert();
    }
    public void update(View view) {

        String table=Db.Tab_MyInfo.TAB_NAME;
        ContentValues values = new ContentValues();
        values.put(Db.Tab_MyInfo.COL_NAME, ((EditText)findViewById(R.id.edtNm)).getText().toString() );
        String whereClause=Db.Tab_MyInfo.COL_CARD_NUM + " =? ";
        String[] whereArgs={((EditText)findViewById(R.id.edtNbr)).getText().toString()};

        SQLiteDatabase sqDb= helper.getWritableDatabase();
        sqDb.update(table,values,whereClause,whereArgs);
        sqDb.close();
    }

    public void delete(View view) {

        String table=Db.Tab_MyInfo.TAB_NAME;
        String whereClause=Db.Tab_MyInfo.COL_CARD_NUM + " =? ";
        String[] whereArgs={((EditText)findViewById(R.id.edtNbr)).getText().toString()};

        SQLiteDatabase sqDb= helper.getWritableDatabase();
        sqDb.delete(table,whereClause,whereArgs);
        sqDb.close();
    }

    public void query(View view) {

        selectOne();
    }

    private void selectOne(){

        String table=Db.Tab_MyInfo.TAB_NAME;
        String[] columns={Db.Tab_MyInfo.COL_NAME};
        String selection=Db.Tab_MyInfo.COL_CARD_NUM + " =? ";
        String[] selectionArgs={((EditText)findViewById(R.id.edtNbr)).getText().toString()};
        String groupBy=null;
        String having=null;
        String orderBy=null;

        SQLiteDatabase sqDb=helper.getReadableDatabase();
        Cursor cursor=sqDb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
        if (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(Db.Tab_MyInfo.COL_NAME));
//            String cardNm=cursor.getString(cursor.getColumnIndex(Db.Tab_MyInfo.COL_CARD_NUM));
            ((EditText)findViewById(R.id.edtNm)).setText(name);
            Log.i(TAG,"Name is "+name);
        }
        sqDb.close();
    }
    private void selectAll(){

        String table=Db.Tab_MyInfo.TAB_NAME;
        String[] columns=null;
        String selection=null;
        String[] selectionArgs=null;
        String groupBy=null;
        String having=null;
        String orderBy=null;

        SQLiteDatabase sqDb=helper.getReadableDatabase();
        Cursor cursor=sqDb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(Db.Tab_MyInfo.COL_NAME));
            String cardNm=cursor.getString(cursor.getColumnIndex(Db.Tab_MyInfo.COL_CARD_NUM));

            Log.i(TAG,"Name is "+name+" And Card Num is "+cardNm);
        }
        sqDb.close();
    }

    private void simmpleInsert(){

        SQLiteDatabase sqDb= helper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Db.Tab_MyInfo.COL_NAME,((EditText)findViewById(R.id.edtNm)).getText().toString());
        values.put(Db.Tab_MyInfo.COL_CARD_NUM,((EditText)findViewById(R.id.edtNbr)).getText().toString());



        long rwId=sqDb.insert(Db.Tab_MyInfo.TAB_NAME,null,values);
        Log.i(TAG,"Row Id is "+rwId);

        sqDb.close();
    }

    private void rawInsert (){
        SQLiteDatabase sqDb=helper.getWritableDatabase();
        sqDb.execSQL(" insert into "+Db.Tab_MyInfo.TAB_NAME +" values('Apple','11')");
        sqDb.close();
    }
}
