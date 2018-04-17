package com.example.dialogs;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void alert(View view){

//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle(getResources().getString(R.string.title))
//                .setMessage(getResources().getString(R.string.msg))
//                .setPositiveButton(R.string.btnYes,null);
//        builder.show();


//        AppDialog dialog=new AppDialog();
//        dialog.show(getSupportFragmentManager(),"TAG_ALERT");

        show(AppDialog.TAG_ALERT);
    }

    public void datePicker(View view) {
        show(AppDialog.TAG_DATE);
    }

    public void timePicker(View view){
        show(AppDialog.TAG_TIME);
    }

    public void progress(View view){
        show(AppDialog.TAG_PROGRESS);
    }
    public void custom(View view){
        show(AppDialog.TAG_CUSTOM);
    }
    public void show(String tag) {
        AppDialog dialog = new AppDialog();
        dialog.show(getSupportFragmentManager(),tag);
    }
}
