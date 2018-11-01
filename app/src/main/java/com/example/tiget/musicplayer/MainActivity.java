package com.example.tiget.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new MusicPlayerFragment()).commit();
        }
    }
}