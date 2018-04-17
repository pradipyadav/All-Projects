package com.example.activitystatemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState !=null){

            My my= (My) savedInstanceState.getSerializable("myDt");
            ((TextView) findViewById(R.id.txtVw)).setText(my.dt);
        }


        mt("onCreate");
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        My my=new My();
        my.dt=((TextView) findViewById(R.id.txtVw)).toString();

        outState.putSerializable("myDt",my);
    }

    public void myClick(View view){
        ((TextView) findViewById(R.id.txtVw)).setText(new Date().toString());
    }
    private void mt(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    class My implements Serializable{
        String dt;
    }
}
