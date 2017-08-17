package com.example.qthjen.watchvideoonline;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String API_KEY = "AIzaSyAtOdWRHwXjhEferqMyd3Jh78b0F3z9TE4";
    YouTubePlayerView youTubePlayerView;
    int REQUEST_VIDEO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.youtube);

        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("vANP12_Runs"); // key lấy trên video của youtube phần sau dấu bằng
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if ( youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(MainActivity.this, REQUEST_VIDEO);
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ( requestCode == REQUEST_VIDEO) {
            youTubePlayerView.initialize(API_KEY, MainActivity.this);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
