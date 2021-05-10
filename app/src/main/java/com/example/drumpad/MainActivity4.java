package com.example.drumpad;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.loader.content.CursorLoader;

import java.io.File;

public class MainActivity4 extends AppCompatActivity {

    public int q = 0;
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

    private MediaRecorder mediaRecorder = null;
    private MediaPlayer mediaPlayer;
    private String fileName;

    Button btn_filePicker;
    Intent myFileIntent;

    public void onClick1(View view) {
        Intent intent = new Intent(MainActivity4.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fileName = Environment.getExternalStorageDirectory() + "/record.3gpp";

        btn_filePicker = (Button) findViewById(R.id.btn_filePicker);

        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q = q + 1;
                myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                myFileIntent.setType("*/*");
                startActivityForResult(myFileIntent, q);
            }
        });

        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK && q == 1) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound1 = sp.load(path, 1);
                }
                break;

            case 2:
                if (resultCode == RESULT_OK && q == 2) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound2 = sp.load(path, 1);
                }
                break;

            case 3:
                if (resultCode == RESULT_OK && q == 3) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound3 = sp.load(path, 1);
                }
                break;

            case 4:
                if (resultCode == RESULT_OK && q == 4) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound4 = sp.load(path, 1);
                }
                break;

            case 5:
                if (resultCode == RESULT_OK && q == 5) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound5 = sp.load(path, 1);
                }
                break;

            case 6:
                if (resultCode == RESULT_OK && q == 6) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound6 = sp.load(path, 1);
                }
                break;

            case 7:
                if (resultCode == RESULT_OK && q == 7) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound7 = sp.load(path, 1);
                }
                break;

            case 8:
                if (resultCode == RESULT_OK && q == 8) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound8 = sp.load(path, 1);
                }
                break;

            case 9:
                if (resultCode == RESULT_OK && q == 9) {
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    String path = getRealPathFromURI(MainActivity4.this, uri);
                    sound9 = sp.load(path, 1);
                    q = 0;
                }
                break;

            default:
                break;
        }
    }

    public void playsound1(View v) {
        sp.play(sound1, 1.0f, 1.0f, 0, 0, 1f);
    }

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
            } catch (RuntimeException stopException) {
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

    private String getRealPathFromURI(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}