package com.example.user.tabfinal;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

public class mainActivity2 extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog pd ;
    VideoView videoView;
    ImageButton btnPlay;

    String URL = "http://mic.duytan.edu.vn:86/FINAL.mp4/ ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = (VideoView)findViewById(R.id.videoView);
        btnPlay = (ImageButton)findViewById(R.id.btnPlay);


    }

    @Override
    public void onClick(View v) {
        pd = new ProgressDialog(mainActivity2.this);
        pd.setMessage("Please wait...");
        pd.setCanceledOnTouchOutside(false);
        pd.show();

            try{
                if(!videoView.isPlaying()){
                Uri uri = Uri.parse(URL);
                videoView.setVideoURI(uri);
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btnPlay.setImageResource(R.drawable.ic_play);

                    }
                });

                }else{
                    videoView.pause();
                    btnPlay.setImageResource(R.drawable.ic_play);
                }

            }
            catch (Exception Ex){

            }

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
                mp.setLooping(true);
                videoView.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
            }
        });
    }
}
