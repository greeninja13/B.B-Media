package com.bbmedia.bbmediaapp;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Brad on 5/24/2017.
 */

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Uri vidUri = Uri.parse("http://10.10.26.252:7777/");

        SurfaceView screen = new SurfaceView(this);
        screen.


        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(this, vidUri);
            player.setDisplay(screen.getHolder());
            player.prepare();
            player.start();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
