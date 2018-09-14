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
public class ParserJsonTest {

    private Context mContext;
    private ParserJson mParserJson;
    @Before
    public void setUp() throws Exception {

        // Context context ＝ new MockContext();
        // mContext = InstrumentationRegistry.getContext(); // 获取测试app的context
        mContext = InstrumentationRegistry.getTargetContext(); // 获取被测试app的context
        mParserJson = new ParserJson(mContext);
    }

    @Test
    public void parserJson() throws Exception {

        String service = mParserJson.parserJson("weather.json");
        assertTrue(service.equalsIgnoreCase("scheduleX"));

    }

}