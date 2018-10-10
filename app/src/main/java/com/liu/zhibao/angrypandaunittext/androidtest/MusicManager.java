package com.liu.zhibao.angrypandaunittext.androidtest;

import android.util.Log;

import com.liu.zhibao.angrypandaunittext.androidtest.inf.netCallBack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhibao.Liu on 2018/10/9.
 *
 * @version :
 * @date : 2018/10/9
 * @des :
 * @see{@link}
 */

public class MusicManager {

    private final static String TAG = "MusicManager";

    private static final MusicManager ourInstance = new MusicManager();

    public static MusicManager getInstance() {
        return ourInstance;
    }

    private MusicManager() {
    }

    public void httpResponse(final String url,final netCallBack callBack){

        /*
        * 注意这里面的区别,如果用线程做异步操作,那么单元测试是无法进行有效测试的
        * */
        new Thread(new Runnable() {//创建子线程
            @Override
            public void run() {
                getwebinfo(url,callBack);//把路径选到MainActivity中
            }
        }).start();//启动子线程
        /*
        * 下面采用同步阻塞的方式进行,
        * 单元测试可以有效进行判断处理
        * */
        // getwebinfo(url,callBack);//把路径选到MainActivity中
    }

    private void getwebinfo(String urlstr,netCallBack callBack) {
        try {
            //1,找水源--创建URL
            URL url = new URL(urlstr/*"https://www.baidu.com/"*/);//放网站
            //2,开水闸--openConnection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //3，建管道--InputStream
            InputStream inputStream = httpURLConnection.getInputStream();
            //4，建蓄水池蓄水-InputStreamReader
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            //5，水桶盛水--BufferedReader
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuffer buffer = new StringBuffer();
            String temp = null;

            while ((temp = bufferedReader.readLine()) != null) {
                //取水--如果不为空就一直取
                buffer.append(temp);
                if(buffer.length()>100){
                    break;
                }
            }
            bufferedReader.close();//记得关闭
            reader.close();
            inputStream.close();
            Log.e(TAG,buffer.toString());//打印结果
            if(buffer.length()>0){
                callBack.onComplete(new String(buffer));
            }else{
                callBack.onError(-1);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
