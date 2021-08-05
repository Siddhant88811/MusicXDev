package com.example.android.musicxdev;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    // For Playing the Music
    public void play(View view)
    {
        player.start();
    }
    // For Pause the Music
    public void pause(View view)
    {
        player.pause();
    }
    // For Stop the Music
    public void stop(View view)
    {
        player.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
player = MediaPlayer.create(this,R.raw.faded);
    }
}