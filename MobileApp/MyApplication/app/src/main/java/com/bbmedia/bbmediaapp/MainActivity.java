package com.bbmedia.bbmediaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(){
        Intent i = new Intent(this, FileList.class);
        System.out.println(i.toString());
        startActivity(i);

    }
}
