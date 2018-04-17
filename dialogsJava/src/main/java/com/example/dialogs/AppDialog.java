package com.example.dialogs;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppDialog extends DialogFragment {

    public static final String TAG_ALERT="alert";
    public static final String TAG_DATE="date";
    public static final String TAG_TIME="time";
    public static final String TAG_PROGRESS="progress";
    public static final String TAG_CUSTOM="custom";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog= new Dialog(Objects.requireNonNull(getActivity()));

        if(Objects.equals(getTag(), TAG_ALERT)) dialog=alert();
        else if(Objects.equals(getTag(), TAG_DATE))dialog=datePicker();
        else if(Objects.equals(getTag(), TAG_TIME))dialog=timePicker();
        else if(Objects.equals(getTag(), TAG_PROGRESS))dialog=progressDialog();
        else dialog=custom();

        return dialog;
    }

    public AlertDialog alert(){

        AlertDialog.Builder builder=new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle(getResources().getString(R.string.title))
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(getResources().getString(R.string.msg))
                .setPositiveButton(R.string.btnYes, (dialog,which)->mt("Yes"))
                .setNegativeButton(R.string.btnNo,(dialog,which)->mt("No"));

        return builder.create();
    }

   private DatePickerDialog datePicker(){
        return new DatePickerDialog(getActivity(),(view, year, month, dayOfMonth) -> mt(""+dayOfMonth+" - "+(month+1)+" - "+year),2018,3,13);
   }

   private TimePickerDialog timePicker(){
        return new TimePickerDialog(getActivity(),(view, hourOfDay, minute) -> mt(""+hourOfDay+" : "+minute),12,5,false);
   }

   @SuppressLint("ResourceType")
   private ProgressDialog progressDialog(){
        ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setTitle(getString(R.string.title));
        progressDialog.setMessage(getString(R.string.msg));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressDialog;
   }

   @SuppressLint("InflateParams")
   private Dialog custom(){
//        final View view=getActivity()
//                .getLayoutInflater().inflate(R.layout.custom_dialog,null, false);

        @SuppressLint("InflateParams") final View view1;
       view1 = Objects.requireNonNull(getActivity()).getLayoutInflater().inflate(R.layout.custom_dialog,null,false);

       AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
       builder.setView(view1);

       return builder.create();
   }

    private void mt(String msg){

        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}
