package com.liu.zhibao.angrypandaunittext.androidtest;

import com.liu.zhibao.angrypandaunittext.androidtest.bean.MockPerson;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des : 框架学习 : https://github.com/hehonghui/mockito-doc-zh
 * @see{@link}
 */
public class MockitoUsingTest {

    @Mock //<--使用@Mock注解
    MockPerson mPerson;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); //<--初始化
    }

    @Test
    public void testIsNotNull() throws Exception {
        // MockPerson mPerson = mock(MockPerson.class); //<--使用mock方法
        assertNotNull(mPerson);
    }

    @Test
    public void testReturn() throws Exception {

        MockPerson person=new MockPerson();
        person.setName("kitty");
        person.setOld(13);
        when(mPerson.getName()).thenReturn("zhibaoliu");
        // when(mPerson.getOld()).thenThrow(new NullPointerException("无法获取年纪"));
        when(mPerson.getOld()).thenReturn(12);

        assertEquals("zhibaoliu",mPerson.getName());
        assertEquals(12,mPerson.getOld());
    }

}