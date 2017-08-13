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
import hqxh.tzpowerproject.model.REQUIREPLAN;


/**
 * 采购申请详情
 */
public class PrdetailsActivity extends BaseActivity {
    private static String TAG = "PrdetailsActivity";

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

    @Bind(R.id.prnum_text_id)
    TextView prnumText;//采购申请
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//账套信息
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//账套描述
    @Bind(R.id.materialsec_text_id)
    TextView materialsecText;//物资费用预算
    @Bind(R.id.materialssc_text_id)
    TextView materialsscText;//物资费用剩余
    @Bind(R.id.totalcost_text_id)
    TextView totalcostText;//预估总价
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.plantype_text_id)
    TextView plantypeText;//计划类型
    @Bind(R.id.projectnum_text_id)
    TextView projectnumText;//项目编号
    @Bind(R.id.projectname_text_id)
    TextView projectnameText;//项目名称
    @Bind(R.id.requireplannum_text_id)
    TextView requireplannumText;//需求计划申请编号
    @Bind(R.id.requestedbyname_text_id)
    TextView requestedbynameText;//需求人
    @Bind(R.id.department1_text_id)
    TextView departmentText;//申请人部门
    @Bind(R.id.issuedate_text_id)
    TextView issuedateText;//请求日期
    @Bind(R.id.requireddate_text_id)
    TextView requireddateText;//要求的日期


    private PR pr;

    private LinearLayout cgsqhLinearLayout; //采购申请行
    private LinearLayout spgcLinearLayout; //审批过程


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_details);
        ButterKnife.bind(PrdetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        pr = (PR) getIntent().getSerializableExtra("pr");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        prnumText.setText(pr.getPRNUM());
        descriptionText.setText(pr.getDESCRIPTION());
        zhangtaoText.setText(pr.getZHANGTAO());
        ztdescriptionText.setText(pr.getALNDOMAIN_ZT_DESCRIPTION());
        materialsecText.setText(pr.getPLANCOST());
        materialsscText.setText(pr.getREMAINCOST());
        totalcostText.setText(pr.getTOTALCOST());
        statusText.setText(pr.getSTATUS());
        plantypeText.setText(pr.getPRTYPE());
        projectnumText.setText(pr.getPROJECTNUM());
        projectnameText.setText(pr.getPROJECTDESC());
        requireplannumText.setText(pr.getREQUIREPLANNUM());
        requestedbynameText.setText(pr.getREQUESTEDBYNAME());
        departmentText.setText(pr.getDEPARTMENT());
        issuedateText.setText(pr.getISSUEDATE());
        requireddateText.setText(pr.getREQUIREDDATE());

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
        View contentView = LayoutInflater.from(PrdetailsActivity.this).inflate(
                R.layout.cgsq_popup_window, null);


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

        cgsqhLinearLayout = (LinearLayout) contentView.findViewById(R.id.plan_text_id);
        spgcLinearLayout = (LinearLayout) contentView.findViewById(R.id.maxrole_text_id);
        cgsqhLinearLayout.setOnClickListener(cgsqhLinearLayoutOnClickListener);
        spgcLinearLayout.setOnClickListener(spgcLinearLayoutOnClickListener);
    }

    private View.OnClickListener cgsqhLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(PrdetailsActivity.this,PrLineListActivity.class);
            intent.putExtra("prnum",pr.getPRNUM());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener spgcLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();

            Intent intent =new Intent(PrdetailsActivity.this,WftransactionListActivity.class);
            intent.putExtra("ownertable", Constants.PR_NAME);
            intent.putExtra("ownerid",pr.getPRID());
            startActivityForResult(intent,0);

        }
    };

}
