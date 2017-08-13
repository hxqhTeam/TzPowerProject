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
import hqxh.tzpowerproject.model.COMPANIES;
import hqxh.tzpowerproject.model.MATECODE;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.model.PR;
import hqxh.tzpowerproject.model.PRLINE;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.model.REQUIREPLANLINE;
import hqxh.tzpowerproject.model.RFQ;
import hqxh.tzpowerproject.model.RFQLINE;
import hqxh.tzpowerproject.model.RFQVENDOR;
import hqxh.tzpowerproject.model.WFASSIGNMENT;
import hqxh.tzpowerproject.model.WFTRANSACTION;

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
    public static ArrayList<WFASSIGNMENT> parsingWFASSIGNMENT(String data) {
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



    /**
     * 需求计划行表
     */
    public static ArrayList<REQUIREPLANLINE> parsingREQUIREPLANLINE(String data) {
        ArrayList<REQUIREPLANLINE> list = null;
        REQUIREPLANLINE requireplanline = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<REQUIREPLANLINE>();
            for (int i = 0; i < jsonArray.length(); i++) {
                requireplanline = new REQUIREPLANLINE();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = requireplanline.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = requireplanline.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(requireplanline);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = requireplanline.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(requireplanline, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(requireplanline);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }



    /**
     * PR主表
     */
    public static ArrayList<PR> parsingPR(String data) {
        ArrayList<PR> list = null;
        PR pr = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<PR>();
            for (int i = 0; i < jsonArray.length(); i++) {
                pr = new PR();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = pr.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = pr.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(pr);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = pr.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(pr, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(pr);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * PRLINE主表
     */
    public static ArrayList<PRLINE> parsingPRLINE(String data) {
        ArrayList<PRLINE> list = null;
        PRLINE prline = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<PRLINE>();
            for (int i = 0; i < jsonArray.length(); i++) {
                prline = new PRLINE();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = prline.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = prline.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(prline);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = prline.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(prline, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(prline);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 审批流程
     */
    public static ArrayList<WFTRANSACTION> parsingWFTRANSACTION(String data) {
        ArrayList<WFTRANSACTION> list = null;
        WFTRANSACTION wftransaction = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<WFTRANSACTION>();
            for (int i = 0; i < jsonArray.length(); i++) {
                wftransaction = new WFTRANSACTION();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = wftransaction.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = wftransaction.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(wftransaction);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = wftransaction.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(wftransaction, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(wftransaction);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RFQ主表
     */
    public static ArrayList<RFQ> parsingRFQ(String data) {
        ArrayList<RFQ> list = null;
        RFQ rfq = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<RFQ>();
            for (int i = 0; i < jsonArray.length(); i++) {
                rfq = new RFQ();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = rfq.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = rfq.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(rfq);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = rfq.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(rfq, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(rfq);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * RFQLINE
     */
    public static ArrayList<RFQLINE> parsingRFQLINE(String data) {
        ArrayList<RFQLINE> list = null;
        RFQLINE rfqline = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<RFQLINE>();
            for (int i = 0; i < jsonArray.length(); i++) {
                rfqline = new RFQLINE();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = rfqline.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = rfqline.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(rfqline);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = rfqline.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(rfqline, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(rfqline);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * RFQLINE
     */
    public static ArrayList<RFQVENDOR> parsingRFQVENDOR(String data) {
        ArrayList<RFQVENDOR> list = null;
        RFQVENDOR rfqvendor = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<RFQVENDOR>();
            for (int i = 0; i < jsonArray.length(); i++) {
                rfqvendor = new RFQVENDOR();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = rfqvendor.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = rfqvendor.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(rfqvendor);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = rfqvendor.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(rfqvendor, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(rfqvendor);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * PAYAPPROVE主表
     */
    public static ArrayList<PAYAPPROVE> parsingPAYAPPROVE(String data) {
        ArrayList<PAYAPPROVE> list = null;
        PAYAPPROVE payapprove = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<PAYAPPROVE>();
            for (int i = 0; i < jsonArray.length(); i++) {
                payapprove = new PAYAPPROVE();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = payapprove.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = payapprove.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(payapprove);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = payapprove.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(payapprove, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(payapprove);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * PO主表
     */
    public static ArrayList<PO> parsingPO(String data) {
        ArrayList<PO> list = null;
        PO po = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<PO>();
            for (int i = 0; i < jsonArray.length(); i++) {
                po = new PO();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = po.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = po.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(po);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = po.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(po, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(po);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 物资编码主表
     */
    public static ArrayList<MATECODE> parsingMATECODE(String data) {
        ArrayList<MATECODE> list = null;
        MATECODE matecode = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<MATECODE>();
            for (int i = 0; i < jsonArray.length(); i++) {
                matecode = new MATECODE();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = matecode.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = matecode.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(matecode);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = matecode.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(matecode, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(matecode);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 供应商主表
     */
    public static ArrayList<COMPANIES> parsingCOMPANIES(String data) {
        ArrayList<COMPANIES> list = null;
        COMPANIES companies = null;
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject;
            list = new ArrayList<COMPANIES>();
            for (int i = 0; i < jsonArray.length(); i++) {
                companies = new COMPANIES();
                jsonObject = jsonArray.getJSONObject(i);
                Field[] field = companies.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
                for (int j = 0; j < field.length; j++) {     //遍历所有属性
                    field[j].setAccessible(true);
                    String name = field[j].getName();    //获取属性的名字
                    if (jsonObject.has(name) && jsonObject.getString(name) != null && !jsonObject.getString(name).equals("")) {
                        try {
                            // 调用getter方法获取属性值
                            Method getOrSet = companies.getClass().getMethod("get" + name);
                            Object value = getOrSet.invoke(companies);
                            if (value == null) {
                                //调用setter方法设属性值
                                Class[] parameterTypes = new Class[1];
                                parameterTypes[0] = field[j].getType();
                                getOrSet = companies.getClass().getDeclaredMethod("set" + name, parameterTypes);
                                getOrSet.invoke(companies, jsonObject.getString(name));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                list.add(companies);
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