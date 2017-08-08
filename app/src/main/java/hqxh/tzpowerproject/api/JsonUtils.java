package hqxh.tzpowerproject.api;

import android.content.Context;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import hqxh.tzpowerproject.bean.LoginResults;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.model.WFASSIGNMENT;

/**
 * Json数据解析类
 */
public class JsonUtils {
    private static final String TAG = "JsonUtils";


    /**
     * 解析登录信息*
     * {"errcode":"USER-S-101","errmsg":"登录成功","result":"{\"DEFSITE\":\"TZDC\",\"DISPLAYNAME\":\"MAXADMIN\",\"EMAILADDRESS\":\"\",
     *
     * \"MYAPPS\":\"COMPANY,GCPAYAPP,MATECODE,PAYAPPROVE,PO,POSER,PR,PRSER,RFQ,RFQSER,RP,SERREC,USER,WFADMIN,WFDESIGN\",
     *
     *
     * \"PERSONID\":\"MAXADMIN\"}","userid":"maxadmin"}

     */
    public static LoginResults parsingAuthStr(final Context cxt, String data) {
        Log.i(TAG, "data=" + data);
        LoginResults loginResults = new LoginResults();
        try {
            JSONObject json = new JSONObject(data);
            String errcode = json.getString("errcode");
            String errmsg = json.getString("errmsg");
            loginResults.setErrcode(errcode);
            loginResults.setErrmsg(errmsg);
            if (errcode.equals(Constants.LOGINSUCCESS) || errcode.equals(Constants.CHANGEIMEI)) {
                loginResults.setResult(json.getString("result"));
            }


            return loginResults;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 分页解析返回的结果*
     */
    public static Results parsingResults(Context ctx, String data) {

        String result = null;
        Results results = null;
        try {
            JSONObject json = new JSONObject(data);
            String jsonString = json.getString("errcode");
            if (jsonString.equals(Constants.GETDATASUCCESS)) {
                result = json.getString("result");
                JSONObject rJson = new JSONObject(result);
                String curpage = rJson.getString("curpage");
                String totalresult = rJson.getString("totalresult");
                String resultlist = rJson.getString("resultlist");
                String totalpage = rJson.getString("totalpage");
                String showcount = rJson.getString("showcount");
                results = new Results();
                results.setCurpage(Integer.valueOf(curpage));
                results.setTotalresult(totalresult);
                results.setResultlist(resultlist);
                results.setTotalpage(totalpage);
                results.setShowcount(Integer.valueOf(showcount));
            }

            return results;


        } catch (JSONException e) {
            e.printStackTrace();
            return results;
        }

    }

    /**
     * 不分页解析返回的结果*
     */
    public static Results parsingResults1(Context ctx, String data) {

        String result = null;
        Results results = null;
        try {
            JSONObject json = new JSONObject(data);
            String jsonString = json.getString("errcode");
            if (jsonString.equals(Constants.GETDATASUCCESS)) {
                result = json.getString("result");
                Log.i(TAG, "result=" + result);
                results = new Results();
                results.setResultlist(result);
                return results;
            }

            return results;


        } catch (JSONException e) {
            e.printStackTrace();
            return results;
        }

    }


    /**
     * 收件箱
     */
    public static ArrayList<WFASSIGNMENT> parsingWFASSIGNMENT(Context ctx, String data) {
        ArrayList<WFASSIGNMENT> list = null;
        WFASSIGNMENT wfassignment = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<WFASSIGNMENT>();
            for (int i = 0; i < jsonArray.length(); i++) {
                wfassignment = new WFASSIGNMENT();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = wfassignment.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = wfassignment.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(wfassignment);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = wfassignment.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(wfassignment, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(wfassignment);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }



    /**
     * 需求计划主表
     */
    public static ArrayList<REQUIREPLAN> parsingREQUIREPLAN(String data) {
        ArrayList<REQUIREPLAN> list = null;
        REQUIREPLAN requireplan = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<REQUIREPLAN>();
            for (int i = 0; i < jsonArray.length(); i++) {
                requireplan = new REQUIREPLAN();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = requireplan.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = requireplan.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(requireplan);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = requireplan.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(requireplan, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(requireplan);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }



    /**解析获取的权限**/
    public static  List<String> getApp(String myApp){
        Log.i(TAG,"myApp="+myApp);
        List<String> list=new ArrayList<String>();
        if(null!=myApp){
            String[] strs=myApp.split(",");
            for (int i=0;i<strs.length;i++){
                Log.e(TAG,"strs[i]="+strs[i]);
                list.add(strs[i]);
            }
        }
        return list;
    }

}