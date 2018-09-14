package com.liu.zhibao.angrypandaunittext.androidtest;

import com.liu.zhibao.angrypandaunittext.androidtest.bean.Datas;

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
public class HelloClassTest {

    private HelloClass mHelloClass;
    @Before
    public void setUp() throws Exception {
        mHelloClass=new HelloClass();
    }

    @Test
    public void addSum() throws Exception {
        assertEquals(6, mHelloClass.addSum(1, 5), 0);
    }

    @Test
    public void replaceStr() throws Exception {
        assertEquals("zdjzdsfjd", mHelloClass.replaceStr("adjadsfjd"));
    }

    @Test
    public void getBeanNum() throws Exception {
        Datas datas=new Datas();
        datas.setName("sdfaf");
        datas.setNum(12);
        assertEquals(11, mHelloClass.getBeanNum(datas));
    }

}