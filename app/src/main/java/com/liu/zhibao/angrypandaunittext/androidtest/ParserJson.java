package com.liu.zhibao.angrypandaunittext.androidtest;

import android.content.Context;
import android.text.TextUtils;

import com.liu.zhibao.angrypandaunittext.DataManager;
import com.liu.zhibao.angrypandaunittext.androidtest.utils.FileUtils;
import com.liu.zhibao.angrypandaunittext.androidtest.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des :
 * @see{@link}
 */

public class ParserJson {
    private Context mContext;
    public ParserJson(Context context){
        mContext = context;
    }

    public String parserJson(String filename){
        String jsonStr = /*DataManager.getInstance().getLoadJson();*/ FileUtils.getFromAssets(mContext,filename/*"weather.json"*/);
        String service="";
        if(!TextUtils.isEmpty(jsonStr)){
            try {
                JSONObject rootJson=new JSONObject(jsonStr);
                service=rootJson.optString("service");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return service;
    }

}
