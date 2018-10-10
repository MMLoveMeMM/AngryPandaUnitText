package com.liu.zhibao.angrypandaunittext.androidtest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

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

        mPlayer.soundPoolLoad("tone/conn.wav");
        /*
        * 等待异步任务的声音播放完成,测试单元方法才能够结束
        * 为了阻止单元测试程序结束,利用休眠阻止3s
        * */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @AfterClass
    public static void afterClass(){
        System.out.println("单元测试结束");
    }
}