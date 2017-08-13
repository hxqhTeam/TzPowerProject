package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.PR;
import hqxh.tzpowerproject.model.RFQ;


/**
 * 询价单详情
 */
public class RfqdetailsActivity extends BaseActivity {
    private static String TAG = "RfqdetailsActivity";

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

    @Bind(R.id.rfqnum_text_id)
    TextView rfqnumText;//询价单
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.quotationtype_text_id)
    TextView quotationtypeText;//报价方式
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//账套信息
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//账套描述
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.person_displayname_text_id)
    TextView person_displaynameText;//输入人
    @Bind(R.id.closeondate_text_id)
    TextView closeondateText;//截止日期


    private RFQ rfq;

    private LinearLayout xjdhLinearLayout; //询价单行
    private LinearLayout gysLayout; //供应商
    private LinearLayout spjlLayout; //审批记录


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rfq_details);
        ButterKnife.bind(RfqdetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        rfq = (RFQ) getIntent().getSerializableExtra("rfq");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        rfqnumText.setText(rfq.getRFQNUM());
        descriptionText.setText(rfq.getDESCRIPTION());
        quotationtypeText.setText(rfq.getQUOTATIONTYPE());
        zhangtaoText.setText(rfq.getZHANGTAO());
        ztdescriptionText.setText(rfq.getALNDOMAIN_ZT_DESCRIPTION());
        statusText.setText(rfq.getSTATUS());
        person_displaynameText.setText(rfq.getPERSON_DISPLAYNAME());
        closeondateText.setText(rfq.getCLOSEONDATE());

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
        View contentView = LayoutInflater.from(RfqdetailsActivity.this).inflate(
                R.layout.xjdh_popup_window, null);


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

        xjdhLinearLayout = (LinearLayout) contentView.findViewById(R.id.plan_text_id);
        gysLayout = (LinearLayout) contentView.findViewById(R.id.gys_text_id);
        spjlLayout = (LinearLayout) contentView.findViewById(R.id.sqjl_text_id);
        xjdhLinearLayout.setOnClickListener(xjdhLinearLayoutOnClickListener);
        gysLayout.setOnClickListener(gysLayoutOnClickListener);
        spjlLayout.setOnClickListener(spjlLayoutOnClickListener);
    }

    private View.OnClickListener xjdhLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(RfqdetailsActivity.this,RfqlineListActivity.class);
            intent.putExtra("title",getResources().getString(R.string.xjdh_text));
            intent.putExtra("rfqnum",rfq.getRFQNUM());
            intent.putExtra("appid",Constants.RFQ_APPID);
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener gysLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(RfqdetailsActivity.this,RfqvendorListActivity.class);
            intent.putExtra("title",getResources().getString(R.string.gys_text));
            intent.putExtra("rfqnum",rfq.getRFQNUM());
            intent.putExtra("appid",Constants.RFQ_APPID);
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener spjlLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(RfqdetailsActivity.this,WftransactionListActivity.class);
            intent.putExtra("ownertable", Constants.RFQ_NAME);
            intent.putExtra("ownerid",rfq.getRFQID());
            startActivityForResult(intent,0);
        }
    };

}
