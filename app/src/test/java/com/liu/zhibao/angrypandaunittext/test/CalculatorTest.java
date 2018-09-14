package com.liu.zhibao.angrypandaunittext.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhibao.Liu on 2018/8/27.
 *
 * @version :
 * @date : 2018/8/27
 * @des :
 * @see{@link}
 */
public class CalculatorTest {
    @Test
    public void multi() throws Exception {
    }

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sum() throws Exception {
        /*
        * 第一个参数为期望的值;
        * 后面调用的被测试方法
        * */
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void substract() throws Exception {
        assertEquals(4d, mCalculator.substract(5d, 1d), 0);
    }

    @Test
    public void divide() throws Exception {
    }

    @Test
    public void multiply() throws Exception {
    }

}