package com.example.android.musicxdev;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audioManager;
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
audioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);
int maxVol= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
int curVol= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

SeekBar seekVol=findViewById(R.id.seekVol);
seekVol.setMax(maxVol);
seekVol.setProgress(curVol);
seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                i,
                0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
       SeekBar seekProg=findViewById(R.id.seekProg);
       seekProg.setMax(player.getDuration());
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               seekProg.setProgress(player.getCurrentPosition());
           }
       },0,1000000);
       seekProg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               player.seekTo(i);
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
    }
}