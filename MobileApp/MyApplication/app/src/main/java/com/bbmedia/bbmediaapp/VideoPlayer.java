package com.bbmedia.bbmediaapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Brad on 5/24/2017.
 */

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        VideoView vidView = (VideoView)findViewById(R.id.Video);

        Uri vidUri = Uri.parse("http://166.70.33.2:7777/");

        vidView.setVideoURI(vidUri);

        vidView.start();

        MediaController vidControl = new MediaController(this);

        vidControl.setAnchorView(vidView);

        vidView.setMediaController(vidControl);
    }
}
