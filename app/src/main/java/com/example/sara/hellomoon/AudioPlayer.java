package com.example.sara.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by sara on 24-Jul-17.
 */

public class AudioPlayer extends Object {

    private MediaPlayer mPlayer;
    private int lenght;

    public void stop()
    {
        if (mPlayer != null)
        {
            mPlayer.release();
            mPlayer = null;
        }
    }
    public void play(Context c)
    {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.seekTo(lenght);
        mPlayer.start();
    }
    public void pauseSong()
    {
        if(mPlayer.isPlaying())
        {
            mPlayer.pause();
            lenght = mPlayer.getCurrentPosition();
        }
    }

}
