package com.liu.zhibao.angrypandaunittext.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/**
 * Created by zhibao.Liu on 2018/8/28.
 *
 * @version :
 * @date : 2018/8/28
 * @des :
 * @see{@link}
 */
public class AnlayStringTest {

    AnlayString anlayString;
    @Before
    public void setUp() throws Exception {
        anlayString = new AnlayString();
    }

    @Test
    public void strArray() throws Exception {
        String[] strs={
                "liu","zhi","bap"
        };
        assertArrayEquals(strs,anlayString.strArray());
    }

    @Test
    public void equalStr() throws Exception {
        // assertFalse(anlayString.equalStr("helloa")); // 不相等,false,即设置的条件是成立的
        assertTrue(anlayString.equalStr("hello"));
    }

    @Test
    public void replaceStr() throws Exception {

        assertEquals("cbcdd", anlayString.replaceStr("abcdd")); // 比较值即可
        // assertSame("cbcdd", anlayString.replaceStr("abcdd")); // 比较Object,说白了就是看地址是不是一样的
    }

    @Test
    public void nullStr() throws Exception {
        assertNull(anlayString.nullStr());
    }

    @Test
    public void notNullStr() throws Exception {
        assertNotNull(anlayString.notNullStr());
    }

}