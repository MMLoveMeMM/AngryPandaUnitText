package com.liu.zhibao.angrypandaunittext.androidtest;

import android.text.TextUtils;

import com.liu.zhibao.angrypandaunittext.androidtest.bean.Datas;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des :
 * @see{@link}
 */

public class HelloClass extends BasicClass implements IBasicInte {
    @Override
    int addSum(int a, int b) {
        return a + b;
    }

    @Override
    public String replaceStr(String info) {
        if (!TextUtils.isEmpty(info)) {
            info = info.replace("a", "z");
        }
        return info;
    }

    public int getBeanNum(Datas datas){
        return datas.getNum();
    }
}
