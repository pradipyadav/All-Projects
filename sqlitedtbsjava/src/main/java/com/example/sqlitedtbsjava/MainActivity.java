package com.example.sqlitedtbsjava;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbHelper myDb;

    EditText edtNm,edtSrNm,edtMks,edtid;
    Button btnAdDt,btnVw,btnUdt,btndlt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DbHelper(this);

        edtNm=(EditText) findViewById(R.id.edtName);
        edtSrNm=(EditText) findViewById(R.id.edtSrName);
        edtMks=(EditText) findViewById(R.id.edtMarks);
        edtid=(EditText) findViewById(R.id.edtId);

        btnAdDt=(Button) findViewById(R.id.btnAddData);
        btnVw=(Button) findViewById(R.id.btnView);
        btnUdt=(Button) findViewById(R.id.btnUpdate);
        btndlt=(Button) findViewById(R.id.btnDelete);

        addData();
        viewAll();
        updataData();
        delete();

    }

    public void addData(){
        btnAdDt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean inserted = myDb.insertData(edtNm.getText().toString(),
                                edtSrNm.getText().toString(),
                                edtMks.getText().toString());

                        if (inserted == true){
                            Toast.makeText(MainActivity.this," Data inserted",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Data not inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void viewAll(){
        btnVw.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor res=myDb.getAllData();
                        if(res.getCount()==0){

                            //Show Message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){

                            buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("Name: "+ res.getString(1) + "\n");
                            buffer.append("Surname: "+ res.getString(2) + "\n");
                            buffer.append("Marks: "+ res.getString(3) + "\n\n");
                        }
                        showMessage("Data",buffer.toString());
                    }
                });
    }

    public void updataData(){
        btnUdt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isUpdate=myDb.updateData(edtid.getText().toString(),
                                edtNm.getText().toString(),
                                edtSrNm.getText().toString(),
                                edtMks.getText().toString());

                        if (isUpdate==true){
                            Toast.makeText(MainActivity.this," Data Update",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Data not Update",Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }

    public void delete(){
        btndlt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows=myDb.deleteData(edtid.getText().toString());

                        if (deleteRows > 0){

                            Toast.makeText(MainActivity.this," Data Delete",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Data not Delete",Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
