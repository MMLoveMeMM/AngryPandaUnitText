package com.liu.zhibao.angrypandaunittext.test;

import android.text.TextUtils;

/**
 * Created by zhibao.Liu on 2018/8/28.
 *
 * @version :
 * @date : 2018/8/28
 * @des :
 * @see{@link}
 */

public class AnlayString {

    public String replaceStr(String info){
        String ret=null;
            if(info.contains("a")){
                ret = info.replace("a","c");
            }
        return ret;
    }

    public String nullStr(){
        return null;
    }

    public String notNullStr(){
        return "hello";
    }

    public boolean equalStr(String data){
        if(data.equalsIgnoreCase("hello")){
            return true;
        }
        return false;
    }

    public String[] strArray(){
        String[] info={
                "liu","zhi","bao"
        };
        return info;
    }
}
