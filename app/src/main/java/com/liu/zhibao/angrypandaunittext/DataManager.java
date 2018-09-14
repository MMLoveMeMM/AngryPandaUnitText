package com.liu.zhibao.angrypandaunittext;

import android.content.Context;
import android.text.TextUtils;

import com.liu.zhibao.angrypandaunittext.androidtest.utils.FileUtils;

/**
 * Created by zhibao.Liu on 2018/9/14.
 *
 * @version :
 * @date : 2018/9/14
 * @des :
 * @see{@link}
 */

public class DataManager {
    private static final DataManager ourInstance = new DataManager();

    public static DataManager getInstance() {
        return ourInstance;
    }

    public String mRootJson;

    private DataManager() {
    }

    public void loadJson(Context context) {

        String jsonStr = FileUtils.getFromAssets(context, "weather.json");
        if (!TextUtils.isEmpty(jsonStr)) {
            mRootJson = jsonStr;
        }

    }

    public String getLoadJson(){
        return mRootJson;
    }


}
