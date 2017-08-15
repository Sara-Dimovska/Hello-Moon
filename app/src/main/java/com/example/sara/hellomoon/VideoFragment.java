package com.example.sara.hellomoon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoFragment extends Fragment {

    private VideoView video;
    private MediaController mediaC;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaC = new MediaController(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video, container, false);

        Uri uri = Uri.parse("android.resource//com.example.sara.hellomoon/"+R.raw.apollo_17_stroll);
        video = (VideoView)v.findViewById(R.id.videoView);
        video.setVideoURI(uri);
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.start();

        return v;
    }



}
