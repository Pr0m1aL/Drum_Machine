package com.example.drumpad;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

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

    public void onClick1(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sp = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);
        sound1 = sp.load(getApplicationContext(), R.raw.melody111, 1);
        sound2 = sp.load(getApplicationContext(), R.raw.melody222, 1);
        sound3 = sp.load(getApplicationContext(), R.raw.melody333, 1);
        sound4 = sp.load(getApplicationContext(), R.raw.hh3, 1);
        sound5 = sp.load(getApplicationContext(), R.raw.oh3, 1);
        sound6 = sp.load(getApplicationContext(), R.raw.clap3, 1);
        sound7 = sp.load(getApplicationContext(), R.raw.snare3, 1);
        sound8 = sp.load(getApplicationContext(), R.raw.kick3, 1);
        sound9 = sp.load(getApplicationContext(), R.raw.perc3, 1);
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
}