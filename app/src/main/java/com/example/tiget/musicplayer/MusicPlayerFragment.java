package com.example.tiget.musicplayer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayerFragment extends Fragment {

    ProgressBar progressBar;
    float progress;
    CountDownTimer mCountDownTimer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_player_fragment_layout, null);

        progressBar = view.findViewById(R.id.progressBar);

        progress = 0;
        setProgressBarTime(4);//Вызываем метод, указывая секунды параметром

        return view;
    }


    public void setProgressBarTime(final int time) {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if(progress <= 100) {
                    progress = progress + 0.2f / time;//Период 1 мс и 0,2f - Полный круг за 1 сек.
                    progressBar.setProgress((int) progress);
                } else {
                    progress = 0;
                }

            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 0, 1);
    }
}
