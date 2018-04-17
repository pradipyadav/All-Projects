package com.example.uithreadjava;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler(Looper.getMainLooper());
    }

    public void startCounter(View view) {

        new MyTask().execute(0,100/*params*/);
        //handlerCounter();

    }

    public void counter(){

        for(int i=0;i<100;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ((TextView)findViewById(R.id.txtctr)).setText(String.valueOf(i));
        }
    }

    private void threadCounter(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter();
            }
        }).start();
    }
      final int i=0;
    private void handlerCounter(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final int finalI = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.txtctr)).setText(String.valueOf(finalI));
                        }
                    });

                }
            }
        }).start();

    }

    @SuppressLint("StaticFieldLeak")
    private class MyTask extends AsyncTask<Integer,String,Boolean>{


        protected void onPreExecute(){
            //UiThread
            super.onPreExecute();
        }

        @Override
        protected Boolean/*Result*/  doInBackground(Integer... params/*params*/) {
            //Worker Thread


            for(int i = params[0]; i<params[1]; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }

            return null;
        }


        protected void onPostExecute(Boolean aBoolean/*Result*/){
            //UiThread
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(String... values/*progress*/) {
            //UiThread
            super.onProgressUpdate(values);
            ((TextView) findViewById(R.id.txtctr)).setText(values[0]);
        }
    }

//    private Observable<String> counterObservable(){
//        return Observable.create(sub->{
//            for (int i=0;i<100;i++){
//                Thread.sleep(500);
//                sub.onNext(String.valueOf(i));
//            }
//            sub.onComplite();
//        });

    }

