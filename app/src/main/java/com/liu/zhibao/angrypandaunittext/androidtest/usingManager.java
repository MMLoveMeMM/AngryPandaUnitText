package com.liu.zhibao.angrypandaunittext.androidtest;

import com.liu.zhibao.angrypandaunittext.androidtest.inf.netCallBack;

/**
 * Created by zhibao.Liu on 2018/10/9.
 *
 * @version :
 * @date : 2018/10/9
 * @des :
 * @see{@link}
 */

public class usingManager{

    public void httpResponse(){
        MusicManager.getInstance().httpResponse("https://www.baidu.com/", new netCallBack() {
            @Override
            public void onComplete(String info) {

            }

            @Override
            public void onError(int code) {

            }
        });
    }

}
