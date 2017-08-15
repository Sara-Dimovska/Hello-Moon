package com.example.sara.hellomoon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;





public class HelloMoonFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;



    private AudioPlayer mPlayer = new AudioPlayer();


    public HelloMoonFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

       mPlayButton = (Button)v.findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.play(getActivity());
            }
        });
       mStopButton = (Button)v.findViewById(R.id.stopButton);
         mStopButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mPlayer.stop();
             }
         });
       mPauseButton = (Button)v.findViewById(R.id.pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.pauseSong();
            }
        });


        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
