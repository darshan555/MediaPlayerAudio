package com.example.mediaplayeraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button play,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playBTN);
        pause = findViewById(R.id.pauseBTN);
        stop = findViewById(R.id.stopBTN);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String mPath = "android.resource://"+getPackageName()+"/raw/mymusic";
        String onlineAudio = "https://themamaship.com/music/Catalog/Africa%20-%20Toto.mp3";

        Uri audioUri = Uri.parse(mPath);
        Uri onlineMp3 = Uri.parse(onlineAudio);

        Log.d("MediaPlayerAudio", "Preparing MediaPlayer");
        try {
            mp.setDataSource(this, onlineMp3);
            mp.prepare();
            Log.d("MediaPlayerAudio", "MediaPlayer prepared");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("MediaPlayerAudio", "Error preparing MediaPlayer: " + e.getMessage());
        }


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });

//        mp.seekTo();
//        mp.getDuration();
//        mp.getCurrentPosition();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });

    }
}