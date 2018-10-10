package com.liu.zhibao.angrypandaunittext.androidtest;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des :
 * @see{@link}
 */

public class Player {

    private Context mContext;
    private SoundPool mSoundPool;
    private AudioManager mAudioManager;

    public Player(Context context) {
        mContext = context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                playNotification(sampleId);
            }
        });
    }

    private void playNotification(int id) {
        int max = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, max, 0);

        if (mSoundPool.play(id, max, max, 1, 0, 1) != 0) {

        } else {
            // error
        }
    }

    public void soundPoolLoad(String fileName) {
        try {
            AssetManager assetManager = mContext.getAssets();
            mSoundPool.load(assetManager.openFd(fileName), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
