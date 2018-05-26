package com.example.webservicesjava;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class App extends Application
{
    private Gson gson;

    private RequestQueue queue;

    public Gson gson(){
        return gson == null? gson = new Gson() : gson;
    }

    public RequestQueue getQueue() {
        return queue == null? queue = Volley.newRequestQueue(this) : queue;
    }
}
