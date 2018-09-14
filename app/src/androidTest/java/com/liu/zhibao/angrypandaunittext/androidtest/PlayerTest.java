package com.liu.zhibao.angrypandaunittext.androidtest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des :
 * @see{@link}
 */
public class PlayerTest {

    private Player mPlayer;
    private Context mContext;

    @Before
    public void setUp() throws Exception {

        mContext = InstrumentationRegistry.getTargetContext(); // 获取被测试app的context
        mPlayer = new Player(mContext);
    }

    @Test
    public void soundPoolLoad() throws Exception {

        mPlayer.soundPoolLoad(""/*"tone/conn.wav"*/);

    }

}