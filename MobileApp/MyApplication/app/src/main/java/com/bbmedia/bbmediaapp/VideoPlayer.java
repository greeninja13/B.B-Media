package com.bbmedia.bbmediaapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Brad on 5/24/2017.
 */

public class VideoPlayer extends Activity implements SurfaceHolder.Callback {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_player);
        Uri vidUri = Uri.parse("http://10.10.26.252:7777/");
//
//        SurfaceView screen = new SurfaceView(this);
////        screen.
//
//
//        MediaPlayer player = new MediaPlayer();
//        try {
//            player.setDataSource(this, vidUri);
//            player.setDisplay(screen.getHolder());
//            player.prepare();
//            player.start();
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//
//

    private MediaPlayer mp;
    private SurfaceView mPreview;
    private SurfaceHolder holder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent recievedIntent= getIntent();
        String file= recievedIntent.getStringExtra("file");
        getWindow().setFormat(PixelFormat.UNKNOWN);
        mPreview = (SurfaceView)findViewById(R.id.Video);
        holder = mPreview.getHolder();
        holder.setFixedSize(800, 480);
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mp = new MediaPlayer();


    }
    protected void onPause(){
        super.onPause();
        mp.release();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        mp.setDisplay(holder);
        play();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
    void play(){
        try {
            mp.setDataSource(this, vidUri);

            mp.prepare();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }

}
