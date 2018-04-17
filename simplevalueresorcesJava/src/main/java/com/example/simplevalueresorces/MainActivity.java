package com.example.simplevalueresorces;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String txtNm=getResources().getString(R.string.txtNm);

        int color=getResources().getColor(R.color.colorAccent);

        color= ContextCompat.getColor(this,R.color.colorAccent);


       String student[]=getResources().getStringArray(R.array.student);
    }
}
