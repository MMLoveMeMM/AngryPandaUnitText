package com.liu.zhibao.angrypandaunittext.androidtest;

import com.liu.zhibao.angrypandaunittext.androidtest.inf.netCallBack;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

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

    private String result="";
    @Test
    public void httpResponse() throws Exception {

        /*
        * 采用信号处理异步任务
        * 利用信号阻塞测试程序
        * 直到等待返回结果以后,将结果获取出来以后
        * 释放信号
        * 测试程序继续运行,然后再进行单元测试
        * 这样的步骤才能够解决之.
        * 处理异步任务总结 :
        * <1> : 使用sleep休眠阻塞测试单元程序运行,直到结果返回,休眠后继续运行;
        * <2> : 使用信号,hold住单元测试程序运行,直到返回结果,释放信号,再继续进行断言判断;
        * <3> : 将异步任务转换成同步任务,这个场合不多,在rxJava中可以在不修改被测试程序的情况下进行变换;
         */
        final CountDownLatch signal = new CountDownLatch(1);

        MusicManager.getInstance().httpResponse("https://cn.bing.com/", new netCallBack() {
            @Override
            public void onComplete(String info) {
                // assertNotNull(info);// 检查这个返回值
                // assertNull(info);// 检查这个返回值
                result= info;
                /*
                * 得到返回结果的时候,也进行了断言判断后,可以释放信号了
                * 让单元测试结束
                * */
                signal.countDown();
            }

            @Override
            public void onError(int code) {
                signal.countDown();
            }
        });

        signal.await();
        assertNotNull(result);// 检查这个返回值
        assertNull(result);// 检查这个返回值

    }

}