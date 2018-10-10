package com.liu.zhibao.angrypandaunittext.androidtest;

import com.liu.zhibao.angrypandaunittext.androidtest.inf.netCallBack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhibao.Liu on 2018/10/9.
 *
 * @version :
 * @date : 2018/10/9
 * @des : 网络测试
 * @see{@link}
 */
public class MusicManagerTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getInstance() throws Exception {
    }

    @Test
    public void httpResponse() throws Exception {

        MusicManager.getInstance().httpResponse("https://cn.bing.com/", new netCallBack() {
            @Override
            public void onComplete(String info) {
                assertNotNull(info);// 检查这个返回值
                assertNull(info);// 检查这个返回值
            }

            @Override
            public void onError(int code) {

            }
        });


    }

}