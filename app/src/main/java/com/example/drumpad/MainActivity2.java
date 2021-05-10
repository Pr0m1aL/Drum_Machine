package com.example.drumpad;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Environment;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound4;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String fileName;

    public void onClick1(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fileName = Environment.getExternalStorageDirectory() + "/record.3gpp";

        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        sound1 = sp.load(getApplicationContext(), R.raw.melody11, 1);
        sound2 = sp.load(getApplicationContext(), R.raw.melody22, 1);
        sound3 = sp.load(getApplicationContext(), R.raw.melody33, 1);
        sound4 = sp.load(getApplicationContext(), R.raw.hh2, 1);
        sound5 = sp.load(getApplicationContext(), R.raw.oh2, 1);
        sound6 = sp.load(getApplicationContext(), R.raw.clap2, 1);
        sound7 = sp.load(getApplicationContext(), R.raw.snare2, 1);
        sound8 = sp.load(getApplicationContext(), R.raw.kick2, 1);
        sound9 = sp.load(getApplicationContext(), R.raw.perc2, 1);
    }

    public void playsound1(View v) { sp.play(sound1, 1.0f, 1.0f, 0, 0, 1f); }

    public void playsound2(View v) {
        sp.play(sound2, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound3(View v) {
        sp.play(sound3, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound4(View v) {
        sp.play(sound4, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound5(View v) {
        sp.play(sound5, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound6(View v) {
        sp.play(sound6, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound7(View v) {
        sp.play(sound7, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound8(View v) {
        sp.play(sound8, 1.0f, 1.0f, 0, 0, 1f);
    }

    public void playsound9(View v) {
        sp.play(sound9, 1.0f, 1.0f, 0, 0, 1f);
    }



    public void recordStart(View v) {
        try {
            releaseRecorder();

            File outFile = new File(fileName);
            if (outFile.exists()) {
                outFile.delete();
            }

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(fileName);
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void recordStop(View v) {
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch(RuntimeException stopException) {
            }
            mediaRecorder = null;
        }
    }

    public void playStart(View v) {
        try {
            releasePlayer();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setVolume(10000.0f, 10000.0f);
            mediaPlayer.setDataSource(fileName);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playStop(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void releaseRecorder() {
        if (mediaRecorder != null) {
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

    private void releasePlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
        releaseRecorder();
    }

}