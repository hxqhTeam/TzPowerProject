package hqxh.tzpowerproject.api;


import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.bean.LoginResults;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.until.AccountUtils;


/**
 * Created by apple on 15/5/27.
 */
public class HttpManager {

    private static AsyncHttpClient sClient = null;
    private static final String TAG = "HttpManager";

    /**
     * 设置待办任务的接口
     */
    public static String getWFASSIGNMENT(String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.WFASSIGNMENT_APPID + "','objectname':'" + Constants.WFASSIGNMENT_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'WFASSIGNMENTID DESC','condition':{'ASSIGNCODE':'=" + persionid + "'}}";

    }

    /**
     * 设置需求计划的接口
     */
    public static String getREQUIREPLAN(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.RP_APPID + "','objectname':'" + Constants.REQUIREPLAN_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'REQUIREPLANNUM DESC'}";
        }
        return "{'appid':'" + Constants.RP_APPID + "','objectname':'" + Constants.REQUIREPLAN_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'REQUIREPLANNUM DESC','sinorsearch':{'REQUIREPLANNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置需求计划申请行的接口
     */
    public static String getREQUIREPLANLINE(String requireplannum, String persionid, int curpage, int showcount) {


        return "{'appid':'" + Constants.RP_APPID + "','objectname':'" + Constants.REQUIREPLANLINE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'REQUIREPLANNUM':'=" + requireplannum + "'}}";
    }


    /**
     * 设置采购申请的接口
     */
    public static String getPR(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.PR_APPID + "','objectname':'" + Constants.PR_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'PRNUM DESC'}";
        }
        return "{'appid':'" + Constants.PR_APPID + "','objectname':'" + Constants.PR_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'PRNUM DESC','sinorsearch':{'PRNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }

    /**
     * 设置采购申请行的接口
     */
    public static String getPRLINE(String prnum, String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.PR_APPID + "','objectname':'" + Constants.PRLINE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'PRNUM':'=" + prnum + "'}}";
    }

    /**
     * 设置工程采购申请的接口
     */
    public static String getPRSER(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.PRSER_APPID + "','objectname':'" + Constants.PR_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'PRNUM DESC'}";
        }
        return "{'appid':'" + Constants.PRSER_APPID + "','objectname':'" + Constants.PR_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'PRNUM DESC','sinorsearch':{'PRNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置审批记录的接口
     */
    public static String getWFADMIN(String ownertable, String ownerid, String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.WFADMIN_APPID + "','objectname':'" + Constants.WFASSIGNMENT_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'OWNERTABLE':'=" + ownertable + "','OWNERID':'=" + ownerid + "'}}";
//        return "{'appid':'" + Constants.WFADMIN_APPID + "','objectname':'" + Constants.WFASSIGNMENT_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
    }


    /**
     * 设置询价单的接口
     */
    public static String getRFQ(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.RFQ_APPID + "','objectname':'" + Constants.RFQ_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'RFQNUM DESC'}";
        }
        return "{'appid':'" + Constants.RFQ_APPID + "','objectname':'" + Constants.RFQ_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'RFQNUM DESC','sinorsearch':{'RFQNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }

    /**
     * 设置询价单行的接口
     */
    public static String getRFQLINE(String appid, String rfqnum, String persionid, int curpage, int showcount) {
        return "{'appid':'" + appid + "','objectname':'" + Constants.RFQLINE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid +  "','condition':{'RFQNUM':'=" + rfqnum + "'}}";
    }
    /**
     * 设置供应商的接口
     */
    public static String getRFQVENDOR(String appid, String rfqnum, String persionid, int curpage, int showcount) {
        return "{'appid':'" + appid + "','objectname':'" + Constants.RFQVENDOR_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid +  "','condition':{'RFQNUM':'=" + rfqnum + "'}}";
    }


    /**
     * 设置工程询价单的接口
     */
    public static String getRFQSER(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.RFQSER_APPID + "','objectname':'" + Constants.RFQ_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
        }
        return "{'appid':'" + Constants.RFQSER_APPID + "','objectname':'" + Constants.RFQ_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','sinorsearch':{'RFQNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }

    /**
     * 设置采购单的接口
     */
    public static String getRO(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC'}";
        }
        return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC','sinorsearch':{'PONUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置采购申请行的接口
     */
    public static String getPOLINE(String ponum, String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.POLINE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'PONUM':'=" + ponum + "'}}";
    }

    /**
     * 设置附件的接口
     */
    public static String getDOCLINKS(String ownertable,String ownerid,String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.CYDOCLI_NAME + "','objectname':'" + Constants.DOCLINKS_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'OWNERTABLE':'=" + ownertable + "','OWNERID':'="+ownerid+"'}}";
    }

    /**
     * 设置付款计划的接口
     */
    public static String getPAYMENTPLAN(String ponum,String persionid, int curpage, int showcount) {
        return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.PAYMENTPLAN_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'PONUM':'=" + ponum +"'}}";
    }

    /**
     * 设置付款执行情况的接口
     */
    public static String getPAYAPPROVE1(String ponum,String persionid, int curpage, int showcount) {
//        return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','condition':{'PONUM':'=" + ponum +"'}}";
        return "{'appid':'" + Constants.PO_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
    }

    /**
     * 设置工程服务采购单的接口
     */
    public static String getPOSER(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.POSER_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC'}";
        }
        return "{'appid':'" + Constants.POSER_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC','sinorsearch':{'PONUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }

    /**
     * 设置工程验收的接口
     */
    public static String getSERREC(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.SERREC_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC'}";
        }
        return "{'appid':'" + Constants.SERREC_APPID + "','objectname':'" + Constants.PO_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','orderby':'POID DESC','sinorsearch':{'PONUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置物资采购付款的接口
     */
    public static String getPAYAPPROVE(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.PAYAPPROVE_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
        }
        return "{'appid':'" + Constants.PAYAPPROVE_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','sinorsearch':{'PAYNUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置物资编码的接口
     */
    public static String getMATECODE(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.MATECODE_APPID + "','objectname':'" + Constants.MATECODE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
        }
        return "{'appid':'" + Constants.MATECODE_APPID + "','objectname':'" + Constants.MATECODE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','sinorsearch':{'MC_MATERIALCODENUM':'" + value + "','DESCRIPTION':'" + value + "'}}";
    }


    /**
     * 设置供应商的接口
     */
    public static String getCOMPANY(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.COMPANY_APPID + "','objectname':'" + Constants.COMPANIES_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
        }
        return "{'appid':'" + Constants.COMPANY_APPID + "','objectname':'" + Constants.COMPANIES_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','sinorsearch':{'COMPANY':'" + value + "','NAME':'" + value + "'}}";
    }

    /**
     * 设置工程付款的接口
     */
    public static String getGCPAYAPP(String value, String persionid, int curpage, int showcount) {
        if (value.equals("")) {
            return "{'appid':'" + Constants.GCPAYAPP_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "'}";
        }
        return "{'appid':'" + Constants.GCPAYAPP_APPID + "','objectname':'" + Constants.PAYAPPROVE_NAME + "','curpage':" + curpage + ",'showcount':" + showcount + ",'option':'read','username':'" + persionid + "','sinorsearch':{'COMPANY':'" + value + "','NAME':'" + value + "'}}";
    }


    /**
     * 使用用户名密码登录
     *
     * @param cxt
     * @param username 用户名
     * @param password 密码
     * @param imei     密码
     * @param handler  返回结果处理
     */
    public static void loginWithUsername(final Context cxt, final String username, final String password, String imei,
                                         final HttpRequestHandler<String> handler) {
        String ip_adress = AccountUtils.getIpAddress(cxt) + Constants.SIGN_IN_URL;
        Log.i(TAG, "ip_adress=" + ip_adress);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("password", password);
        params.put("imei", imei);
        client.post(ip_adress, params, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Log.i(TAG, "SstatusCode=" + statusCode + "responseString=" + responseString);
                SafeHandler.onFailure(handler, IMErrorType.errorMessage(cxt, IMErrorType.ErrorLoginFailure));
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.i(TAG, "SstatusCode=" + statusCode + "responseString=" + responseString);
                if (statusCode == 200) {
                    LoginResults loginResults = JsonUtils.parsingAuthStr(cxt, responseString);
                    if (loginResults != null) {
                        if (loginResults.getErrcode().equals(Constants.LOGINSUCCESS) || loginResults.getErrcode().equals(Constants.CHANGEIMEI)) {
                            SafeHandler.onSuccess(handler, loginResults.getResult());
                        } else if (loginResults.getErrcode().equals(Constants.USERNAMEERROR)) {
                            SafeHandler.onFailure(handler, loginResults.getErrmsg());
                        }
                    }

                }
            }

        });


    }


    /**
     * 不分页获取信息方法*
     */
    public static void getData(final Context cxt, String data, final HttpRequestHandler<Results> handler) {
        Log.i(TAG, "data=" + data);
        String ip_adress = AccountUtils.getIpAddress(cxt) + Constants.BASE_URL;
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("data", data);
        client.post(ip_adress, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFailure(handler, cxt.getString(R.string.get_data_info_fail));
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {

                Results result = JsonUtils.parsingResults1(cxt, responseString);
                if (null == result) {
                    SafeHandler.onFailure(handler, cxt.getString(R.string.get_data_info_fail));
                } else {
                    SafeHandler.onSuccess(handler, result, result.getCurpage(), result.getShowcount());
                }
            }

        });
    }


    /**
     * 解析返回的结果--分页*
     */
    public static void getDataPagingInfo(final Context cxt, String data, final HttpRequestHandler<Results> handler) {
        Log.i(TAG, "data=" + data);
        String ip_adress = AccountUtils.getIpAddress(cxt) + Constants.BASE_URL;

        Log.i(TAG, "ip_adress=" + ip_adress);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("data", data);
        client.post(ip_adress, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFailure(handler, cxt.getString(R.string.get_data_info_fail));
            }


            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.e(TAG, "responseString=" + responseString);
                Results result = JsonUtils.parsingResults(cxt, responseString);
                if (null == result) {
                    SafeHandler.onFailure(handler, cxt.getString(R.string.get_data_info_fail));
                } else {
                    SafeHandler.onSuccess(handler, result, result.getCurpage(), result.getShowcount());
                }

            }

        });
        client.setConnectTimeout(50000000);
    }


    /**
     * 发送工作流
     *
     * @cxt 上下文
     * @ownertable 工作流对应的主表名称
     * @ownerid 工作流对应的主表主键
     * @processname 工作流名称
     * @useruid 当前登录人的唯一标识
     */
    public static void startFlow(final Context cxt, final String ownertable, final String ownerid, final String processname, final String useruid,
                                 final HttpRequestHandler<String> handler) {


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("ownertable", ownertable);
        params.put("ownerid", ownerid);
        params.put("processname", processname);
        params.put("useruid", useruid);
        client.post(Constants.START_FLOW_URL, params, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFailure(handler, IMErrorType.errorMessage(cxt, IMErrorType.ErrorLoginFailure));
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.i(TAG, "SstatusCode=" + statusCode + "responseString=" + responseString);

            }

        });


    }

    /**
     * 审批工作流
     *
     * @ownertable 工作流对应的主表名称
     * @ownerid 工作流对应的主表主键
     * @memo 审批意见
     * @selectWhat 是否接受：true/false
     * useruid 当前登录人的唯一标识
     */
    public static void approvalFlow(final Context cxt, final String ownertable, final String ownerid, final String memo, final String selectWhat, final String useruid,
                                    final HttpRequestHandler<String> handler) {


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("ownertable", ownertable);
        params.put("ownerid", ownerid);
        params.put("memo", memo);
        params.put("selectWhat", selectWhat);
        params.put("useruid", useruid);
        client.post(Constants.APPROVAL_FLOW_URL, params, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFailure(handler, IMErrorType.errorMessage(cxt, IMErrorType.ErrorLoginFailure));
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Log.i(TAG, "SstatusCode=" + statusCode + "responseString=" + responseString);
            }

        });


    }


}
