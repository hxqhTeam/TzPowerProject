package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.model.RFQ;


/**
 * 采购单详情
 */
public class PodetailsActivity extends BaseActivity {
    private static String TAG = "PodetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;

    /**菜单按钮**/
    @Bind(R.id.title_add)
    ImageView menuImageView;

    private PopupWindow popupWindow;

    @Bind(R.id.ponum_text_id)
    TextView ponumText;//采购单编号
    @Bind(R.id.podescription_text_id)
    TextView podescriptionText;//采购单描述
    @Bind(R.id.pogenre_text_id)
    TextView pogenreText;//采购单类型
    @Bind(R.id.ishtbh_checkbox_id)
    CheckBox ishtbhText;//合同编号?
    @Bind(R.id.connum_text_id)
    TextView connumText;//合同编号
    @Bind(R.id.owner_text_id)
    TextView ownerText;//所属单位
    @Bind(R.id.dwmc_text_id)
    TextView dwmcText;//单位名称
    @Bind(R.id.contractstatus_text_id)
    TextView contractstatusText;//合同情况
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//帐套信息
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//帐套描述
    @Bind(R.id.ytqk_text_id)
    TextView ytqkText;//委托情况
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.pretaxtotal_text_id)
    TextView pretaxtotalText;//税前总价
    @Bind(R.id.totaltax1_text_id)
    TextView totaltax1Text;//税款总计
    @Bind(R.id.totalcost_text_id)
    TextView totalcostText;//税后总价
    @Bind(R.id.receipts_text_id)
    TextView receiptsText;//入库情况
    @Bind(R.id.vendor_text_id)
    TextView vendorText;//供应商
    @Bind(R.id.name_text_id)
    TextView nameText;//供应商名称
    @Bind(R.id.contact_text_id)
    TextView contactText;//联系人
    @Bind(R.id.voicephone_text_id)
    TextView voicephoneText;//办公电话
    @Bind(R.id.faxphone_text_id)
    TextView faxphoneText;//传真
    @Bind(R.id.cellphone_text_id)
    TextView cellphoneText;//手机号
    @Bind(R.id.email_text_id)
    TextView emailText;//邮箱地址
    @Bind(R.id.memo_text_id)
    TextView memoText;//询比价情况


    private PO po;

    private TextView cgdText; //采购单行
    private TextView htwbText; //合同文本
    private TextView fkjhText; //付款计划
    private TextView fkzxqkText; //付款执行情况
    private TextView spjlText; //审批历史


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_details);
        ButterKnife.bind(PodetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        po = (PO) getIntent().getSerializableExtra("po");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        ponumText.setText(po.getPONUM());
        podescriptionText.setText(po.getDESCRIPTION());
        pogenreText.setText(po.getPOGENRE());
        if(po.getISHTBH().equals("0")){
            ishtbhText.setChecked(false);
        }else{
            ishtbhText.setChecked(true);
        }
        connumText.setText(po.getCONNUM());
        ownerText.setText(po.getOWNER());
        dwmcText.setText(po.getDOMAIN_DESCRIPTION());
        contractstatusText.setText(po.getCONTRACTSTATUS());
        zhangtaoText.setText(po.getZHANGTAO());
        ztdescriptionText.setText(po.getALNDOMAIN_ZT_DESCRIPTION());
        ytqkText.setText(po.getYTQK());
        statusText.setText(po.getSTATUS());
        pretaxtotalText.setText(po.getPRETAXTOTAL());
        totaltax1Text.setText(po.getTOTALTAX1());
        totalcostText.setText(po.getTOTALCOST());
        receiptsText.setText(po.getRECEIPTS());
        vendorText.setText(po.getVENDOR());
        nameText.setText(po.getPO_VENDOR_NAME());
        contactText.setText(po.getVENDOR_CONTACT_CONTACT());
        voicephoneText.setText(po.getVENDOR_CONTACT_VOICEPHONE());
        faxphoneText.setText(po.getVENDOR_CONTACT_FAXPHONE());
        cellphoneText.setText(po.getVENDOR_CONTACT_CELLPHONE());
        emailText.setText(po.getVENDOR_CONTACT_EMAIL());
        memoText.setText(po.getMEMO());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }

    //菜单按钮
    @OnClick(R.id.title_add)
    void setMenuImageView(){
        showPopupWindow(menuImageView);
    }


    /**
     * 初始化showPopupWindow*
     */
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(PodetailsActivity.this).inflate(
                R.layout.cgd_popup_window, null);


        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                return false;
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.popup_background_mtrl_mult));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

        cgdText = (TextView) contentView.findViewById(R.id.cgdh_text_id);
        htwbText = (TextView) contentView.findViewById(R.id.htwb_text_id);
        fkjhText = (TextView) contentView.findViewById(R.id.fkjh_text_id);
        fkzxqkText = (TextView) contentView.findViewById(R.id.fkzxqk_text_id);
        spjlText = (TextView) contentView.findViewById(R.id.spjl_text_id);
        cgdText.setOnClickListener(cgdTextOnClickListener);
        htwbText.setOnClickListener(htwbTextOnClickListener);
        fkjhText.setOnClickListener(fkjhTextOnClickListener);
        fkzxqkText.setOnClickListener(fkzxqkTextOnClickListener);
        spjlText.setOnClickListener(spjlTextOnClickListener);
    }

    private View.OnClickListener cgdTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PodetailsActivity.this,PoLineListActivity.class);
            intent.putExtra("ponum",po.getPONUM());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener htwbTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PodetailsActivity.this,DoclinksListActivity.class);
            intent.putExtra("title",getResources().getString(R.string.htwb_text));
            intent.putExtra("ownertable",Constants.PO_NAME);
            intent.putExtra("ownerid",po.getPOID());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener fkjhTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PodetailsActivity.this,PaymentplanListActivity.class);
            intent.putExtra("ponum", po.getPONUM());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener fkzxqkTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PodetailsActivity.this,PayapproveItemListActivity.class);
            intent.putExtra("ponum", po.getPONUM());
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener spjlTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PodetailsActivity.this,WftransactionListActivity.class);
            intent.putExtra("ownertable",Constants.PO_NAME);
            intent.putExtra("ownerid",po.getPOID());
            startActivityForResult(intent,0);
        }
    };

}
