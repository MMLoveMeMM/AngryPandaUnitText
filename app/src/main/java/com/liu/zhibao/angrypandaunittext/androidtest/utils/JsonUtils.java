package com.liu.zhibao.angrypandaunittext.androidtest.utils;

/**
 * Created by 020200184 on 2018/4/10.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    /*{
        "method": "dm_set",
            "req_id": 178237278,
            "timestamp": 123456789,
            "nodeid": " AI_router.main.platform ",
            "params": {
        "user_id": 2003,
                "family_id": 1,
                "device_uuid": "112233445566778810",
                "attribute": {
            "platform" :1   //0-默认，1-讯飞，2-微软小冰，3-腾讯小薇						}
        }
    }*/
    public static void makeJsonInfo(){

        JSONObject rootJson=new JSONObject();
        try {
            rootJson.put("method","dm_set");
            rootJson.put("nodeid","AI_router.main.platform");

            JSONObject paramsJson=new JSONObject();
            paramsJson.put("user_id",2003);
            paramsJson.put("family_id",1);
            paramsJson.put("device_uuid","112233445566778810");

            JSONObject attributeJson=new JSONObject();
            attributeJson.put("platform",1);

            paramsJson.put("attribute",attributeJson);
            rootJson.put("params",paramsJson);

            //rootJson.put("params")
            Log.d("MainActivity",rootJson.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static void parseJsonWithJsonObject(String jsonData){

        try {
            JSONObject rootJson = new JSONObject(jsonData);
            int rc=rootJson.getInt("rc");
            Log.i("MainActivity","rc : "+rc);

            // 获取data数组值
            JSONObject dataJson = rootJson.getJSONObject("data");
            JSONArray jsonArray=dataJson.getJSONArray("result");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String date=jsonObject.getString("datetime.date");
                Log.i("MainActivity","date : "+date);
            }

            // 获取semantic下的suggestDatetime参数值
            JSONArray jsonsugArray=rootJson.getJSONArray("semantic");
            for(int i=0;i<jsonsugArray.length();i++){
                JSONObject jsonObject = jsonsugArray.getJSONObject(i);
                //获取slots
                JSONArray jsonslotArray=jsonObject.getJSONArray("slots");
                for(int j=0;j<jsonslotArray.length();j++){
                    JSONObject jsonSubObject = jsonslotArray.getJSONObject(i);
                    String normValue=jsonSubObject.getString("normValue");
                    Log.i("MainActivity","normValue : "+normValue);

                    JSONObject rootsubJson = new JSONObject(normValue);
                    String suggestDatetime=rootsubJson.getString("suggestDatetime");
                    Log.i("MainActivity","suggestDatetime : "+suggestDatetime);

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void parseJSONWithJSONArray(String jsonData){
        try {
            //将json字符串jsonData装入JSON数组，即JSONArray
            //jsonData可以是从文件中读取，也可以从服务器端获得
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i< jsonArray.length(); i++) {
                //循环遍历，依次取出JSONObject对象
                //用getInt和getString方法取出对应键值
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int rc = jsonObject.getInt("rc");
                Log.d("MainActivity","weather json rc : " + rc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 自动从json映射到javabean
    * */
    public static <T> T parseJsonTobean(JSONObject obj,T bean) {

        try {
            List<Field> fieldList = new ArrayList<Field>();
            fieldList
                    .addAll(Arrays.asList(bean.getClass().getDeclaredFields()));
            for (Field field : fieldList) {
                String name = field.getName();
                if(name.contains("$")){
                    continue;
                }
                Object value = null;
                value = obj.opt(name);
                if (value != null /*&& !(value instanceof null)*/) {
                    //使其可以对私有属性复制
                    field.setAccessible(true);
                    if (name.equalsIgnoreCase("Option")) {
                        JSONArray jArr = (JSONArray) value;
                        field.set(bean, jArr.toString());
                    } else {
                        String type = field.getType().toString();
                        if (type.indexOf("Integer") >= 0) {
                            field.set(bean, (Integer) value);
                        } else if (type.indexOf("String") >= 0) {
                            field.set(bean, (String) value);
                        }
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
