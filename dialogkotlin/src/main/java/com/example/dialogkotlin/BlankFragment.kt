package com.example.dialogkotlin


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import java.sql.Time
import java.util.*
import kotlin.math.min


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        when(tag){
            "Alert" -> {
                return AlertDialog.Builder(activity as Context)
                        .setTitle("Title")
                        .setMessage("MESSAGE")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("Okay",
                                { dialog, which -> Log.i("@MSG","okay")})
                        .setNegativeButton("Cancel",
                                { dialog, which -> Log.i("@MSG","Cancel")}).create()
            }


            "TimePickerDialog" -> {
                return TimePickerDialog(activity ,
                        {view, hourOfDay, minute -> Log.i("@MSG","$hourOfDay : $minute") } ,
                        10,15,false)
            }

            "DatePickerDialog" ->{
                return  DatePickerDialog(activity ,
                        { _: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->  Log.i("@MSG"," $dayOfMonth- ${month + 1} - $year")}
                        ,2018,4,8)
            }

            "CustomDialog" ->{
                return  AlertDialog.Builder(activity as Context)
                        .setView(R.layout.my_dialog)
                        .setTitle("my Custom Dialog")
                        .setIcon(R.mipmap.ic_launcher)
                        .create()

            }

            "CurrentDateDialog" ->{
                val cal = Calendar.getInstance()
                val year = cal.get(Calendar.YEAR)
                val month = cal.get(Calendar.MONTH)
                val day = cal.get(Calendar.DAY_OF_MONTH)

                return  DatePickerDialog(activity ,
                        { _: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->  Log.i("@MSG"," $dayOfMonth- ${month + 1} - $year")}
                        ,year ,month,day)

            }
            "CurrentTimeDialog" ->{
                var cal = Calendar.getInstance()
                var time = cal.get(Calendar.MINUTE)
                var hour = cal.get(Calendar.HOUR_OF_DAY)
                return TimePickerDialog(activity ,
                        {view, hourOfDay, minute -> Log.i("@MSG","$hourOfDay : $minute") } ,
                        hour,time,false)

            }

        }
        return Dialog(activity as Context)
    }
}