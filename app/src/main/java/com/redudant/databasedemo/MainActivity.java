package com.redudant.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       try
       {

           //create database
           SQLiteDatabase eventsDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);

           //create table
           eventsDB.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");

           //isi database
           eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Avengers', 2019)");

           eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Captain America', 2018)");

           //select query table database
           Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);

           int eventIndext = c.getColumnIndex("event");
           int yearIndext = c.getColumnIndex("year");

           c.moveToFirst();

           while (c != null)
           {
               Log.i("Result - event", c.getString(eventIndext));
               Log.i("Result - age", Integer.toString(c.getInt(yearIndext)));

               c.moveToNext();
           }

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
