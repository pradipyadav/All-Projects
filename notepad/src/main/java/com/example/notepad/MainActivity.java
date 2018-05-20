package com.example.notepad;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbHelper myDb;

    EditText edtid,edtTitle,edtNote;
    Button btnAdDt,btnVw,btnUdt;
    ImageButton btndlt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DbHelper(this);

        edtid=(EditText) findViewById(R.id.editText);
        edtTitle=(EditText) findViewById(R.id.editText2);
        edtNote=(EditText) findViewById(R.id.editText3);


        btnAdDt=(Button) findViewById(R.id.btn_Save);
        btnVw=(Button) findViewById(R.id.button2);
        btnUdt=(Button) findViewById(R.id.button3);
        btndlt=(ImageButton) findViewById(R.id.imageButton);

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
                        boolean inserted = myDb.insertData(edtTitle.getText().toString(),
                                edtNote.getText().toString());

                        if (inserted == true){
                            Toast.makeText(MainActivity.this," Save ",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Not Save ",Toast.LENGTH_LONG).show();
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
                            showMessage("Error","No notes found");
                            return;
                        }

                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){

                            buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("Title: "+ res.getString(1) + "\n");
                            buffer.append("Note: "+ res.getString(2) + "\n\n");
                        }
                        showMessage("Notes",buffer.toString());
                    }
                });
    }

    public void updataData(){
        btnUdt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isUpdate=myDb.updateData(edtid.getText().toString(),
                                edtTitle.getText().toString(),
                                edtNote.getText().toString());

                        if (isUpdate==true){
                            Toast.makeText(MainActivity.this," Notepad Update",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Notepad not Update",Toast.LENGTH_LONG).show();

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

                            Toast.makeText(MainActivity.this," Note Delete",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this," Note not Delete",Toast.LENGTH_LONG).show();

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
