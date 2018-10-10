package com.liu.zhibao.angrypandaunittext.androidtest.inf;

/**
 * Created by zhibao.Liu on 2018/10/9.
 *
 * @version :
 * @date : 2018/10/9
 * @des :
 * @see{@link}
 */

public interface netCallBack {
    void onComplete(String info);
    void onError(int code);
}
