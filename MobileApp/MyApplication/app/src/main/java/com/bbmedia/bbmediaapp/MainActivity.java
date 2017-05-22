package com.bbmedia.bbmediaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View view){
        try {
            Intent i = new Intent(this, FileList.class);
            
            startActivity(i);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
