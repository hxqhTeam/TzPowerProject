package hqxh.tzpowerproject.constants;

/**
 * Created by apple on 15/10/8.
 * 静态常量类
 */
public class Constants {

    /**
     * 基础接口*
     */

    /**
     * 默认 外网*
     */
    public static final String HTTP_API_IP = "http://221.230.139.180:7001";
    //本地
//    public static final String HTTP_API_IP = "http://192.168.101.164:7001";
    /**
     * 内网*
     */
    public static final String HTTPZHENGSHI_API_IP = "http://10.1.88.101";

    //登陆URL
    public static final String SIGN_IN_URL ="/maximo/mobile/system/login";


    //通用接口查询
    public static final String BASE_URL =  "/maximo/mobile/common/api";



    //发送工作流接口

    public static final String START_FLOW_URL = "/maximo/mobile/wf/start";
    //审批工作流接口
    public static final String APPROVAL_FLOW_URL ="/maximo/mobile/wf/approve";


    /**
     * 图片*
     */
    public static final String WORK_FLOW_URL = "/meaweb/services/WFSERVICE";

    /**
     * ------------------数据库表名配置－－开始*
     */

    //收件箱appid
    public static final String WFASSIGNMENT_APPID = "WFDESIGN" ;
    //审批记录appid
    public static final String WFADMIN_APPID = "WFADMIN" ;
    //审批记录的表名
    public static final String WFTRANSACTION_NAME = "WFTRANSACTION" ;

    //收件箱的表名
    public static final String WFASSIGNMENT_NAME = "WFASSIGNMENT";

    //需款计划的appid
    public static final String RP_APPID = "RP";

    //需款计划的表名
    public static final String REQUIREPLAN_NAME = "REQUIREPLAN";
    //需款计划申请行的表名
    public static final String REQUIREPLANLINE_NAME = "REQUIREPLANLINE";

    //采购申请的appid
    public static final String PR_APPID = "PR";
    //采购申请的表名
    public static final String PR_NAME = "PR";
    //采购申请的表名
    public static final String PRLINE_NAME = "PRLINE";


    //询价单的appid
    public static final String RFQ_APPID = "RFQ";

    //询价单的表名
    public static final String RFQ_NAME = "RFQ";

    //询价单行的表名
    public static final String RFQLINE_NAME = "RFQLINE";
    //供应商的表名
    public static final String RFQVENDOR_NAME = "RFQVENDOR";

    //采购单的appid
    public static final String PO_APPID = "PO";
    //采购单的表名
    public static final String PO_NAME = "PO";
    //采购单行的表名
    public static final String POLINE_NAME = "POLINE";


    //附件的appid
    public static final String CYDOCLI_NAME = "CYDOCLI";
    //附件的表名
    public static final String DOCLINKS_NAME = "DOCLINKS";

    //付款计划的表名
    public static final String PAYMENTPLAN_NAME = "PAYMENTPLAN";



    //物资采购付款的appid
    public static final String PAYAPPROVE_APPID = "PAYAPPROVE";
    //物资采购付款的表名
    public static final String PAYAPPROVE_NAME = "PAYAPPROVE";

    //物资编码的appid
    public static final String MATECODE_APPID = "MATECODE";
    //物资编码的表名
    public static final String MATECODE_NAME = "MATECODE";

    //工程采购申请的appid
    public static final String PRSER_APPID = "PRSER";

    //工程询价单的appid
    public static final String RFQSER_APPID = "RFQSER";
    //工程服务采购单的appid
    public static final String POSER_APPID = "POSER";
    //供应商的appid
    public static final String COMPANY_APPID = "COMPANY";
    //供应商的表名
    public static final String COMPANIES_NAME = "COMPANIES";
    //工程验收的appid
    public static final String SERREC_APPID = "SERREC";
    //工程付款的appid
    public static final String GCPAYAPP_APPID = "GCPAYAPP";




    /**
     * 用户登录表识--开始*
     */
    public static final String LOGINSUCCESS = "USER-S-101"; //登录成功

    public static final String CHANGEIMEI = "USER-S-104"; //登录成功,检测到用户更换手机登录

    public static final String USERNAMEERROR = "USER-E-100";//用户名密码错误

    public static final String GETDATASUCCESS = "GLOBAL-S-0";//获取数据成功



}
